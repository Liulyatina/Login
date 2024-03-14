package by.it_academy.jd2.service.api;

import by.it_academy.jd2.service.dto.MessageDTO;

import java.util.List;

public interface IMessageService {
    List<MessageDTO> getMessageForUser(String login);

    void sendMessage(MessageDTO message);
}
