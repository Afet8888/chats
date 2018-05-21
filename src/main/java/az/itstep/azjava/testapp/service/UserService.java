package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    User signUp(User user);

    List<Message> messageListByReceiver(Integer id);

    List<Message> messageListBySender(Integer id);

    String signIn(User user);
    User update (User user);
    void delete(Integer id);
    User findByToken (String token);

}
