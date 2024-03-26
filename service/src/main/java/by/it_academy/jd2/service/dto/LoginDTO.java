package by.it_academy.jd2.service.dto;

import lombok.Getter;

@Getter
public class LoginDTO {
    private final String login;
    private final String password;

    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
