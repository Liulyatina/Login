package by.it_academy.jd2.service.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationUserDTO {
    private String login;
    private String password;
    private String name;
    private LocalDate birthday;
}