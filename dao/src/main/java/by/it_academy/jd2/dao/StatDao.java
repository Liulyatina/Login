package by.it_academy.jd2.dao;

import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.dao.api.IStatDao;

import java.util.concurrent.atomic.AtomicInteger;

public class StatDao implements IStatDao {

    private AtomicInteger user = new AtomicInteger(0);
    private AtomicInteger message = new AtomicInteger(0);
    private AtomicInteger activeUsers = new AtomicInteger(0);

    public StatDao(int messages, int users, int activeUsers) {
        this.message = new AtomicInteger(messages);
        this.user = new AtomicInteger(users);
        this.activeUsers = new AtomicInteger(activeUsers);
    }

    public StatDao() {

    }

    @Override
    public StatDTO get() {
        return StatDTO.builder()
                .users(this.user.get())
                .messages(this.message.get())
                .activeUsers(this.activeUsers.get())
                .build();
    }

    @Override
    public void incrementUser() {
        this.user.incrementAndGet();
    }

    @Override
    public void decrementUser() {
        this.user.decrementAndGet();
    }

    @Override
    public void incrementMessage() {
        this.message.incrementAndGet();
    }

    @Override
    public void decrementMessage() {
        this.message.decrementAndGet();
    }

    @Override
    public void incrementActiveUser() {
        this.activeUsers.incrementAndGet();
    }

    @Override
    public void decrementActiveUser() {
        this.activeUsers.decrementAndGet();
    }
}
