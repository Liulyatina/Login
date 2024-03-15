package by.it_academy.jd2.dao.api;

import by.it_academy.jd2.core.dto.MessageDTO;
import by.it_academy.jd2.core.dto.UserDTO;

import java.util.List;

public interface IMessageDao {

    List<MessageDTO> list(UserDTO forUser);

    void create(MessageDTO dto);

}
