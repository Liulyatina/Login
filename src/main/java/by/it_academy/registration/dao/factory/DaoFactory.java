package by.it_academy.registration.dao.factory;

import by.it_academy.registration.dao.UserDao;

public class DaoFactory {
    private static volatile UserDao userDao;

    private DaoFactory() {}

    public static UserDao getUserDao() {
        if (userDao == null) {
            synchronized (DaoFactory.class) {
                if (userDao == null) {
                    userDao = new UserDao();
                }
            }
        }
        return userDao;
    }
}