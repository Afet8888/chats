package az.itstep.azjava.testapp.Controller;


import az.itstep.azjava.testapp.model.Message;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    User singUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    @PutMapping
    String signIn(@RequestBody User user) {
        return userService.signIn(user);
    }

    @PutMapping("/update")
    User update(@RequestBody User user) { return userService.update(user);}

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @GetMapping("/messages/bysender/{id}")
    public List<Message> getBySenderId(@PathVariable Integer id) {
        return userService.messageListBySender(id);
    }

    @GetMapping("/messages/byreciever/{id}")
    public List<Message> getByReceiverId(@PathVariable Integer id) {
        return userService.messageListByReceiver(id);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
