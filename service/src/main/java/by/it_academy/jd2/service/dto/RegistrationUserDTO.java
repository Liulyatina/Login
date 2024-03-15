package by.it_academy.jd2.service.dto;

import by.it_academy.jd2.core.dto.UserRole;

import java.time.LocalDate;

public class RegistrationUserDTO {
    private String login;
    private String password;
    private String name;
    private LocalDate birthday;
    private UserRole role;

    public RegistrationUserDTO() {
    }

    public RegistrationUserDTO(String login, String password, String name, LocalDate birthday, UserRole role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}

