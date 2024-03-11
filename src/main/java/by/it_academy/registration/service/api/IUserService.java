package by.it_academy.registration.service.api;

import by.it_academy.registration.dao.dto.UserDto;

import java.time.LocalDate;

public interface IUserService {
    UserDto save(String login, String password, String fullName, LocalDate birthDate);

    boolean getUserByLogin(String login, String password);
}