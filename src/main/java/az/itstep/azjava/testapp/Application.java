package az.itstep.azjava.testapp;

import az.itstep.azjava.testapp.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ComponentScan - base package gosterir
 * @EnableAutoConfiguration
 */
@SpringBootApplication
public class Application {

    /*  ***DTO***
     User { id, username, password, email }
    Message { id, text, sendTime, senderId,
                        receiverId }

    POST /signup  USER -> save user
    POST /signin {username, password} -> TOKEN
    GET /chats -> Get all chats for this user
    GET /chats/{senderId} -> Get all messages with
                            sender
    POST /chats MESSAGE -> save new message
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public Map<String, User> getAuthorizedUsers() {
        return new TreeMap<>();
    }

}

