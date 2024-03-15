package by.it_academy.jd2.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class SendMessageDTO {

    private LocalDateTime dateTime;
    private String from;
    private String to;
    private String text;

}