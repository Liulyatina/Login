package by.it_academy.jd2.dao;

import by.it_academy.jd2.core.dto.MessageDTO;
import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.dao.api.IMessageDao;
import by.it_academy.jd2.dao.api.IStatDao;
import by.it_academy.jd2.dao.factory.DaoFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDao implements IMessageDao {

    private final Map<String, List<MessageDTO>> fromUser = new HashMap<>();
    private final Map<String, List<MessageDTO>> forUser = new HashMap<>();

    @Override
    public List<MessageDTO> list(UserDTO forUser) {
        return this.forUser.get(forUser.getLogin());
    }

    @Override
    public void create(MessageDTO dto) {

        List<MessageDTO> fromList = this.fromUser.getOrDefault(dto.getFrom(), new ArrayList<>());
        fromList.add(dto);
        this.fromUser.put(dto.getFrom(), fromList);

        List<MessageDTO> forList = this.forUser.getOrDefault(dto.getTo(), new ArrayList<>());
        forList.add(dto);
        this.forUser.put(dto.getTo(), forList);
    }
}
