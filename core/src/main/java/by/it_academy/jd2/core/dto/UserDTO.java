package by.it_academy.jd2.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTO {
    private String login;
    private String password;
    private UserRole role;
    private String name;
    private LocalDate birthday;
    private LocalDateTime dtRegistration;

    public UserDTO() {
    }

    public UserDTO(String login, String password, UserRole role, String name, LocalDate birthday, LocalDateTime dtRegistration) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.birthday = birthday;
        this.dtRegistration = dtRegistration;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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

    public LocalDateTime getDtRegistration() {
        return dtRegistration;
    }

    public void setDtRegistration(LocalDateTime dtRegistration) {
        this.dtRegistration = dtRegistration;
    }
}
