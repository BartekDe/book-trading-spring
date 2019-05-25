package pl.bartekde.booktradingspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.bartekde.booktradingspring.entity.User;
import pl.bartekde.booktradingspring.service.UserService;
import pl.bartekde.booktradingspring.user.CrmUser;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;
    
    @Autowired
    public RegisterController(UserService userService) {
    	this.userService = userService;
    }

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistration(Model theModel) {
        theModel.addAttribute("crmUser", new CrmUser());

        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult theBindingResult,
            Model theModel
    ) {
        String username = theCrmUser.getUsername();
        logger.info("Processing registration form for:" + username);

        // form validation
        if (theBindingResult.hasErrors()) {
            return "registration-form";
        }

        // check the database if the user already exists
        User existing = userService.findByUsername(username);
        if (existing != null) {
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationForm", "User already exists.");

            logger.warning("Username already exists.");
            return "registration-form";
        }

        // create user's account
        userService.save(theCrmUser);

        logger.info("Successfully created user: " + username);

        return "registration-confirmation";

    }
}
