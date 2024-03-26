package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.service.api.IAuthService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.dto.LoginDTO;

import java.util.Optional;

public class AuthService implements IAuthService {

    private static final String WRONG_LOGIN_OR_PASSWORD = "Логин или пароль неверны";

    private final IUserService userService;

    public AuthService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO login(LoginDTO login) {
        Optional<UserDTO> optional = this.userService.getByLogin(login.getLogin());

        if (optional.isEmpty()) {
            throw new IllegalArgumentException(WRONG_LOGIN_OR_PASSWORD);
        }

        UserDTO userDTO = optional.get();

        if (!userDTO.getPassword().equals(login.getPassword())) {
            throw new IllegalArgumentException(WRONG_LOGIN_OR_PASSWORD);
        }

        return userDTO;
    }
}
