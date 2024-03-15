package by.it_academy.jd2.service.api;

import by.it_academy.jd2.core.dto.MessageDTO;
import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.service.dto.SendMessageDTO;

import java.util.List;

public interface IMessageService {
    List<MessageDTO> list(UserDTO toUser);

    void create(UserDTO from, SendMessageDTO dto);
}
