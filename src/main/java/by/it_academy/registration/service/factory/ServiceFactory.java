package by.it_academy.registration.service.factory;

import by.it_academy.registration.dao.UserDao;
import by.it_academy.registration.dao.factory.DaoFactory;
import by.it_academy.registration.service.UserService;

public class ServiceFactory {
    private static volatile UserService userService;

    private ServiceFactory() {}

    public static UserService getUserService() {
        if (userService == null) {
            synchronized (ServiceFactory.class) {
                if (userService == null) {
                    UserDao userDao = DaoFactory.getUserDao();
                    userService = new UserService(userDao);
                }
            }
        }
        return userService;
    }
}