package by.it_academy.jd2.dao.api;

import by.it_academy.jd2.core.dto.StatDTO;

public interface IStatDao {

    StatDTO get();

    void incrementUser();

    void decrementUser();

    void incrementMessage();

    void decrementMessage();

    void incrementActiveUser();

    void decrementActiveUser();
}
