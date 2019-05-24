package pl.bartekde.booktradingspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bartekde.booktradingspring.entity.User;

@RestController
@RequestMapping("/rest")
public class TestController {
    @GetMapping("/hello")
    public User helloRest() {
        User testUser = new User();
        testUser.setFirstName("Bartosz");
        testUser.setLastName("Nazwisko");
        return testUser;
    }
}
