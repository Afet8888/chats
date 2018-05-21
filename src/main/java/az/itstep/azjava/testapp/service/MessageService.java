package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    Message save(Message message, String token);
    Message update(Message message, String token);
    void delete(Integer id, String token);
    Message getById(Integer senderId, String token);
    List<Message> findAll(String token);
}
