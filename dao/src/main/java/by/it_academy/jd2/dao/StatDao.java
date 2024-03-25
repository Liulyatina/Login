package by.it_academy.jd2.dao;

import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.dao.api.IMessageDao;
import by.it_academy.jd2.dao.api.IStatDao;
import by.it_academy.jd2.dao.api.IUserDao;
import by.it_academy.jd2.dao.factory.DaoFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class StatDao implements IStatDao {
    private int user;
    private int message;
    private int activeUsers;
    private IUserDao userDao = DaoFactory.getUserDao();
    private IMessageDao messageDao = DaoFactory.getMessageDao();

    public StatDao(int messages, int users, int activeUsers) {
        this.message = messages;
        this.user = users;
        this.activeUsers = activeUsers;
    }

    public StatDao() {

    }

    @Override
    public StatDTO get() {
        return StatDTO.builder().
                users(this.user).
                messages(this.message).
                activeUsers(this.activeUsers).
                build();
    }

    @Override
    public void incrementUser() {
        this.user++;
    }

    @Override
    public void decrementUser() {
        this.user--;
    }

    @Override
    public void incrementMessage() {
        this.message++;
    }

    @Override
    public void decrementMessage() {
        this.message--;
    }

    @Override
    public void incrementActiveUser() {
        this.activeUsers++;
    }

    @Override
    public void decrementActiveUser() {
        this.activeUsers--;
    }
}
