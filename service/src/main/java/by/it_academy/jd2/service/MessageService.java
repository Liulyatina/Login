package by.it_academy.jd2.service;

import by.it_academy.jd2.core.dto.MessageDTO;
import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.dao.api.IMessageDao;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.dto.SendMessageDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MessageService implements IMessageService {
    private final IMessageDao messageDao;
    private final IUserService userService;
    private final IStatService statService;

    public MessageService(IMessageDao messageDao, IUserService userService, IStatService statService) {
        this.messageDao = messageDao;
        this.userService = userService;
        this.statService = statService;
    }

    @Override
    public List<MessageDTO> list(UserDTO forUser) {
        return this.messageDao.list(forUser);
    }

    @Override
    public void create(UserDTO from, SendMessageDTO dto) {

        Optional<UserDTO> userTo = userService.getByLogin(dto.getTo());
        Optional<UserDTO> userFrom = userService.getByLogin(from.getLogin());

        if (userTo.isEmpty()) {
            throw new IllegalArgumentException("Нет пользователя которому вы отправляете не существует");
        }

        if (userFrom.isEmpty()) {
            throw new IllegalArgumentException("Нет пользователя от которого вы отправляете не существует");
        }

        MessageDTO message = MessageDTO.builder()
                .from(from.getLogin())
                .to(dto.getTo())
                .text(dto.getText())
                .dateTime(LocalDateTime.now())
                .build();

        this.messageDao.create(message);

        statService.incrementMessage();

    }
}
