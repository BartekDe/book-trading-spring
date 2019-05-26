package pl.bartekde.booktradingspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bartekde.booktradingspring.entity.User;
import pl.bartekde.booktradingspring.service.UserService;

import java.util.logging.Logger;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public User showUser(@PathVariable int userId) {
        User testUser = userService.findById(userId);
        return testUser;
    }
}
