package az.itstep.azjava.testapp.service.dto;

import az.itstep.azjava.testapp.dao.UserRepository;
import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.model.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MessageDtoService {

    private UserRepository userRepository;



    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
