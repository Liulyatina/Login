package by.it_academy.jd2.core.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String login;
    private String password;
    private UserRole role;
    private String name;
    private LocalDate birthday;
    private LocalDateTime dtRegistration;
}
