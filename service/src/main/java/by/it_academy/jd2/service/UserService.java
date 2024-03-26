package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.UserRole;
import by.it_academy.jd2.dao.api.IUserDao;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.core.dto.UserDTO;


import java.time.LocalDateTime;
import java.util.Optional;

public class UserService implements IUserService {

    private final IUserDao userDao;
    private final IStatService statService;

    public UserService(IUserDao userDao, IStatService statService) {
        this.userDao = userDao;
        this.statService = statService;
    }

    @Override
    public void create(UserDTO userDTO) {

        if (userDTO.getRole() == null) {
            throw new IllegalArgumentException("Роль должна быть обязательно указана");
        }
        if (userDTO.getLogin() == null || userDTO.getLogin().isBlank()) {
            throw new IllegalArgumentException("Логин должен быть обязательно указан");
        }
        if (userDTO.getPassword() == null || userDTO.getPassword().isBlank()) {
            throw new IllegalArgumentException("Пароль должен быть обязательно указан");
        }

        Optional<UserDTO> byLogin = this.userDao.getByLogin(userDTO.getLogin());

        if (byLogin.isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }

        userDTO.setDtRegistration(LocalDateTime.now());

        this.userDao.create(userDTO);

        statService.incrementUser();
    }

    @Override
    public void create(RegistrationUserDTO registrationUserDTO) {
        UserDTO user = new UserDTO();
        user.setLogin(registrationUserDTO.getLogin());
        user.setPassword(registrationUserDTO.getPassword());
        user.setRole(UserRole.USER);
        user.setName(registrationUserDTO.getName());
        user.setBirthday(registrationUserDTO.getBirthday());

        create(user);
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return this.userDao.getByLogin(login);
    }

}
