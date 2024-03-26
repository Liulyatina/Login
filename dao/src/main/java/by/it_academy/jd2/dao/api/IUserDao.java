package by.it_academy.jd2.dao.api;

import by.it_academy.jd2.core.dto.UserDTO;

import java.util.Optional;

public interface IUserDao {
    void create(UserDTO user);

    Optional<UserDTO> getByLogin(String login);
}
