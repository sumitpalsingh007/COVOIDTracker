package com.sps.covoid.tracker.controller;

import com.sps.covoid.tracker.entities.User;
import com.sps.covoid.tracker.form.LoginForm;
import com.sps.covoid.tracker.form.RegisterForm;
import com.sps.covoid.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

/**
 * The type Login controller.
 */
@Controller
public class RegisterController {

    final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Register.
     *
     * @return the {@link String}
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "registerForm")final RegisterForm registerForm,
                        final Model model) {
        if (StringUtils.equals(registerForm.getPassword(), registerForm.getConfirmPassword())) {
            userRepository.save(new User(registerForm.getUserName(),
                    registerForm.getConfirmPassword()));
            return "login";
        }
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getLoginForm() {
        return "register";
    }
}
