package by.it_academy.jd2.service;

import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.dto.MessageDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private final Map<String, List<MessageDTO>> userMessageMap;

    public MessageService() {
        this.userMessageMap = new HashMap<>();
    }

    @Override
    public List<MessageDTO> getMessageForUser(String login) {
        return userMessageMap.getOrDefault(login,new ArrayList<>());
    }

    @Override
    public void sendMessage(MessageDTO message) {
        String recipient = message.getTo();
        List<MessageDTO> recipientMessage = userMessageMap.getOrDefault(recipient, new ArrayList<>());
        recipientMessage.add(message);
        userMessageMap.put(recipient, recipientMessage);

    }
}
