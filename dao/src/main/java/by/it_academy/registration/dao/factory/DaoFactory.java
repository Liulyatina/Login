package by.it_academy.registration.dao.factory;

import by.it_academy.registration.dao.UserDao;
import by.it_academy.registration.dao.api.IUserDao;

public class DaoFactory {
    private static volatile IUserDao userDao;

    private DaoFactory() {}

    public static UserDao getUserDao() {
        if (userDao == null) {
            synchronized (DaoFactory.class) {
                if (userDao == null) {
                    userDao = new UserDao();
                }
            }
        }
        return (UserDao) userDao;
    }
}