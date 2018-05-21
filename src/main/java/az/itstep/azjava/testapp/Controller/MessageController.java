package az.itstep.azjava.testapp.Controller;

import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.MessageService;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/messages")

public class MessageController {

    private MessageService messageService;


    @PostMapping
    Message save(@RequestBody Message message, @RequestHeader HttpHeaders headers) {
            return messageService.save(message,headers.get("token").get(0));
    }

    @PutMapping
    Message update(@RequestBody Message message, @RequestHeader HttpHeaders headers) {

        return messageService.update(message, headers.get("token").get(0));
    }

    @DeleteMapping("/{id}")
    void delete (@PathVariable Integer id, @RequestHeader HttpHeaders headers) { messageService.delete(id, headers.get("token").get(0));}

    @GetMapping("/{id}")
    Message getById(@PathVariable Integer id, @RequestHeader HttpHeaders headers) { return messageService.getById(id, headers.get("token").get(0));}

    @GetMapping
    public List<Message> findAll(@RequestHeader HttpHeaders headers ){
        return messageService.findAll(headers.get("token").get(0));  }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

}
