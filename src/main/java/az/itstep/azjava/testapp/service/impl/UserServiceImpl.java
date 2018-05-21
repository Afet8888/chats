package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.MessageRepository;
import az.itstep.azjava.testapp.dao.UserRepository;
import az.itstep.azjava.testapp.exceptions.WrongUserDataException;
import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.model.dto.UserDTO;
import az.itstep.azjava.testapp.service.UserService;
import az.itstep.azjava.testapp.service.dto.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MessageRepository messageRepository;
    private Map<String, User> authorizedUsers;


    @Override
    public User signUp(User user) {

        return userRepository.save(user);
    }

   @Override
   public List<Message> messageListByReceiver(Integer id){
        List<Message> messages = (List<Message>) messageRepository.findAll();
        return messages.parallelStream()
                .filter(message ->
                        message.getReceiverId()
                                .equals(id))
                .collect(Collectors.toList());
   }

   @Override
   public List<Message> messageListBySender(Integer id) {
        List<Message> messages = (List<Message>) messageRepository.findAll();
        return messages.parallelStream()
                .filter(message ->
                message.getSenderId()
                .equals(id))
                .collect(Collectors.toList());
   }


    @Override
    public String signIn(User user) {
        Optional<User> dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser.isPresent()) {
            String password = dbUser.get().getPassword();
            if (Objects.equals(password, user.getPassword())) {
                String token = UUID.randomUUID().toString();
                authorizedUsers.put(token, dbUser.get());
                return token;
            }
        }
        throw new RuntimeException("wrong username or password");
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getId()))
            return userRepository.save(user);
        throw new WrongUserDataException("Wrong User");
    }

    @Override
    public void delete(Integer id) {
        if (Objects.isNull(id))
            throw new WrongUserDataException("Wrong Id");
        userRepository.deleteById(id);
    }

    @Override
    public User findByToken(String token) {
        return authorizedUsers.get(token);
    }

    @Autowired
    public void setAuthorizedUsers(Map<String, User> authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
    }

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
