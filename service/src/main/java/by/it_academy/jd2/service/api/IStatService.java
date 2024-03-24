package by.it_academy.jd2.service.api;

import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.service.dto.LoginDTO;

public interface IStatService {

    StatDTO get(LoginDTO loginDTO);
    void incrementUser();

    void decrementUser();

    void incrementMessage();

    void decrementMessage();

    void incrementActiveUser();

    void decrementActiveUser();
}
