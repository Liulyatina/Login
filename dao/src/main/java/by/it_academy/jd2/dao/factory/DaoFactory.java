package by.it_academy.jd2.dao.factory;

import by.it_academy.jd2.dao.MessageDao;
import by.it_academy.jd2.dao.UserDao;
import by.it_academy.jd2.dao.api.IMessageDao;
import by.it_academy.jd2.dao.api.IUserDao;

public class DaoFactory {

    private volatile static IUserDao userDao;

    private volatile static IMessageDao massageDao;

    public static IUserDao getUserDao(){
        if(userDao == null){
            synchronized (DaoFactory.class){
                if(userDao == null){
                    userDao = new UserDao();
                }
            }
        }
        return userDao;
    }

    public static IMessageDao getMassageDao(){
        if(massageDao == null){
            synchronized (DaoFactory.class){
                if(massageDao == null){
                    massageDao = new MessageDao();
                }
            }
        }
        return massageDao;
    }
}
