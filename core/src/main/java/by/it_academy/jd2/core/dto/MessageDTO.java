package by.it_academy.jd2.core.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDTO {

    private LocalDateTime dateTime;
    private String from;
    private String to;
    private String text;

}