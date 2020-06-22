package com.sps.covoid.tracker.controller;

import com.sps.covoid.tracker.form.LoginForm;
import com.sps.covoid.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The type Login controller.
 */
@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    /**
     * Login boolean.
     *
     * @return the boolean
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm")final LoginForm loginForm,
                        final Model model) {
        if (null != userRepository.getIdForExistingUser(
                loginForm.getUserName(), loginForm.getPassword())) {
            return "home";
        }
        model.addAttribute("invalidCredentials", true);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }
}
