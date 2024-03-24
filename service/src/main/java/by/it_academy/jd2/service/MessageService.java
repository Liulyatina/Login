package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.MessageDTO;
import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.dao.api.IMessageDao;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.dto.SendMessageDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MessageService implements IMessageService {

    private final IMessageDao dao;
    private final IUserService userService;

    public MessageService(IMessageDao dao, IUserService userService) {
        this.dao = dao;
        this.userService = userService;
    }

    @Override
    public List<MessageDTO> list(UserDTO forUser) {
        return this.dao.list(forUser);
    }

    @Override
    public void create(UserDTO from, SendMessageDTO dto) {

        Optional<UserDTO> userTo = userService.getByLogin(dto.getTo());
        Optional<UserDTO> userFrom = userService.getByLogin(from.getLogin());

        if(userTo.isEmpty()){
            throw new IllegalArgumentException("Нет пользователя которому вы отправляете не существует");
        }

        if(userFrom.isEmpty()){
            throw new IllegalArgumentException("Нет пользователя от которого вы отправляете не существует");
        }

        MessageDTO create = MessageDTO.builder()
                .from(from.getLogin())
                .to(dto.getTo())
                .text(dto.getText())
                .dateTime(LocalDateTime.now())
                .build();

        this.dao.create(create);

    }
}
