package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.MessageRepository;
import az.itstep.azjava.testapp.exceptions.MessageNotFoundException;
import az.itstep.azjava.testapp.exceptions.WrongUserDataException;
import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.model.dto.MessageDTO;
import az.itstep.azjava.testapp.service.MessageService;
import az.itstep.azjava.testapp.service.UserService;
import az.itstep.azjava.testapp.service.dto.MessageDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private UserService userService;
    private MessageRepository messageRepository;

    @Override
    public Message save(Message message, String token) {
        User user = userService.findByToken(token);
        if (Objects.isNull(user))
            throw new WrongUserDataException("User Not Found");
        if (Objects.isNull(message))
            throw new MessageNotFoundException("Message  NotFound");
        return messageRepository.save(message);
    }

    @Override
    public Message update(Message message, String token) {
        User user = userService.findByToken(token);
        if (Objects.isNull(user))
            throw new WrongUserDataException("User Not Found");
        if (!message.getSenderId().equals(user.getId()))
            throw new WrongUserDataException("This User Not Permitted");
        if (Objects.isNull(message.getSenderId())
                || Objects.isNull(message.getId())
                || Objects.isNull(message.getSendTime()))
            throw new MessageNotFoundException("Message  Not Found");
        return messageRepository.save(message);
    }

    @Override
    public void delete(Integer id, String token) {
        Message message = messageRepository.findById(id).orElse(null);
        if (Objects.isNull(message))
            throw new MessageNotFoundException("Message  Not Found");
        User user = userService.findByToken(token);
        if (Objects.isNull(user))
            throw new WrongUserDataException("User Not Found");
        messageRepository.deleteById(id);
    }

    @Override
    public Message getById(Integer senderId, String token) {
        User user = userService.findByToken(token);
        if (Objects.isNull(user))
            throw new WrongUserDataException("User Not Found");
        return messageRepository.findById(senderId).orElse(null);
    }

    @Override
    public List<Message> findAll(String token) {
        return (List<Message>) messageRepository.findAll();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
