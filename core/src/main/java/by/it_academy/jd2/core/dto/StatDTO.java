package by.it_academy.jd2.core.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class StatDTO {
    private long users;
    private long activeUsers;
    private long messages;
}