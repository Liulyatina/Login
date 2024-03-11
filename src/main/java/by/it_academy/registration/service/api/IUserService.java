package by.it_academy.registration.service.api;

import by.it_academy.registration.controller.User;

import java.time.LocalDate;

public interface IUserService {
    User registerUser(String login, String password, String fullName, LocalDate birthDate);

    boolean loginUser(String login, String password);
}