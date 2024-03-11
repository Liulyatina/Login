package by.it_academy.registration.dao.dto;

import java.time.LocalDate;

public class UserDto {
    private String login;
    private String password;
    private String fullName;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private String role;

    public UserDto(String login, String password, String fullName, LocalDate birthDate, LocalDate registrationDate, String role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public UserDto(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getRole() {
        return role;
    }

    public void add(UserDto user) {
    }
}
