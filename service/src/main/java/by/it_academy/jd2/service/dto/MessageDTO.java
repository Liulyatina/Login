package by.it_academy.jd2.service.dto;

import java.time.LocalDateTime;

public class MessageDTO {

    private  LocalDateTime dateTime;
    private String from;
    private String to;
    private String text;

    public MessageDTO() {
    }

    public MessageDTO(LocalDateTime dateTime, String from, String to, String text) {
        this.dateTime = dateTime;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
