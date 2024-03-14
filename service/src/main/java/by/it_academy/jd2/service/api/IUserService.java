package by.it_academy.jd2.service.api;

import by.it_academy.jd2.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.core.dto.UserDTO;

import java.util.Optional;

public interface IUserService {

    void create(UserDTO userDTO);

    void create(RegistrationUserDTO registrationUserDTO);

    Optional<UserDTO> getByLogin(String login);
}
