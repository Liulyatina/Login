package by.it_academy.registration.dao.api;

import by.it_academy.registration.dao.dto.UserDto;

import java.time.LocalDate;

public interface IUserDao {
    boolean addUser(String login, String password, String fullName, LocalDate birthDate);

    boolean getUserByLogin(String login, String password);
}
