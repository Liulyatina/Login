package by.it_academy.jd2.service.factory;

import by.it_academy.jd2.dao.factory.DaoFactory;
import by.it_academy.jd2.service.AuthService;
import by.it_academy.jd2.service.MessageService;
import by.it_academy.jd2.service.UserService;
import by.it_academy.jd2.service.api.IAuthService;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IUserService;

public class ServiceFactory {

    private volatile static IUserService userService;
    private volatile static IAuthService authService;

    private volatile static IMessageService messageService;

    public static IUserService getUserService(){
        if(userService == null){
            synchronized (ServiceFactory.class){
                if(userService == null){
                    userService = new UserService(DaoFactory.getUserDao());
                }
            }
        }
        return userService;
    }

    public static IAuthService getAuthService(){
        if(authService == null){
            synchronized (ServiceFactory.class){
                if(authService == null){
                    authService = new AuthService(getUserService());
                }
            }
        }
        return authService;
    }

    public static IMessageService getMessageService(){
        if(messageService == null){
            synchronized (ServiceFactory.class){
                if(messageService == null){
                    messageService = new MessageService();
                }
            }
        }
        return messageService;
    }
}
