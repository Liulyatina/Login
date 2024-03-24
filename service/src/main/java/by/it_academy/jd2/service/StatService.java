package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.dao.StatDao;
import by.it_academy.jd2.dao.api.IStatDao;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.dto.LoginDTO;

import java.util.Optional;

public class StatService implements IStatService {

    private final IStatDao statDao;
    private final IUserService userService;

    public StatService(IStatDao statDao, IUserService userService) {

        this.statDao = statDao;
        this.userService = userService;
    }

    @Override
    public StatDTO get(LoginDTO loginDTO) {

        Optional<UserDTO> userByLogin = userService.getByLogin(loginDTO.getLogin());

        if (userByLogin.isEmpty()) {
            throw new IllegalArgumentException("Пользователя с таким логином не существует");
        }

        UserDTO user = userByLogin.get();

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new IllegalArgumentException("Пароль не верный");
        }

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