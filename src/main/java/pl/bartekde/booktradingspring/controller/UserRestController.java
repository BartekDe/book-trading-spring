package pl.bartekde.booktradingspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bartekde.booktradingspring.entity.User;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	int id;
    @GetMapping("/user")
    public User showUser() {
        // TODO: 24.05.2019 remove hardcoded user
        User testUser = new User();
        
        
        testUser.setFirstName("Bartosz");
        testUser.setLastName("Nazwisko");
        return testUser;
    }
}
