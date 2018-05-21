package az.itstep.azjava.testapp.service.dto;

import az.itstep.azjava.testapp.dao.MessageRepository;
import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDtoService {

    private MessageRepository messageRepository;


    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
