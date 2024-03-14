package by.it_academy.jd2.dao.factory;

import by.it_academy.jd2.dao.UserDao;
import by.it_academy.jd2.dao.api.IUserDao;

public class DaoFactory {

    private volatile static IUserDao userDao;

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
}
