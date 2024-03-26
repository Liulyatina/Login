package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.dao.api.IStatDao;
import by.it_academy.jd2.service.api.IStatService;

import java.util.Optional;

public class StatService implements IStatService {

    private final IStatDao statDao;

    public StatService(IStatDao statDao) {
        this.statDao = statDao;
    }

    @Override
    public StatDTO get() {
        return statDao.get();
    }

    @Override
    public void incrementUser() {
        statDao.incrementUser();
    }

    @Override
    public void decrementUser() {
        statDao.decrementUser();
    }

    @Override
    public void incrementMessage() {
        statDao.incrementMessage();
    }

    @Override
    public void decrementMessage() {
        statDao.decrementMessage();
    }

    @Override
    public void incrementActiveUser() {
        statDao.incrementActiveUser();
    }

    @Override
    public void decrementActiveUser() {
        statDao.decrementActiveUser();
    }

}