package by.it_academy.jd2.service.api;

import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.service.dto.LoginDTO;

public interface IAuthService {
    UserDTO login(LoginDTO login);
}
