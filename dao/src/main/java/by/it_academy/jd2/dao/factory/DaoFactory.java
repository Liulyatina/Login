package by.it_academy.jd2.dao.factory;

import by.it_academy.jd2.dao.MessageDao;
import by.it_academy.jd2.dao.StatDao;
import by.it_academy.jd2.dao.UserDao;
import by.it_academy.jd2.dao.api.IMessageDao;
import by.it_academy.jd2.dao.api.IStatDao;
import by.it_academy.jd2.dao.api.IUserDao;

public class DaoFactory {

    private volatile static IUserDao userDao;

    private volatile static IMessageDao messageDao;

    private volatile static IStatDao statDao;

    public static IUserDao getUserDao() {
        if (userDao == null) {
            synchronized (DaoFactory.class) {
                if (userDao == null) {
                    userDao = new UserDao();
                }
            }
        }
        return userDao;
    }

    public static IMessageDao getMessageDao() {
        if (messageDao == null) {
            synchronized (DaoFactory.class) {
                if (messageDao == null) {
                    messageDao = new MessageDao();
                }
            }
        }
        return messageDao;
    }

    public static IStatDao getStatDao() {
        if (statDao == null) {
            synchronized (DaoFactory.class) {
                if (statDao == null) {
                    statDao = new StatDao();
                }
            }
        }
        return statDao;
    }
}
