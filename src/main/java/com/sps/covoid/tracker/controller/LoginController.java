package com.sps.covoid.tracker.controller;

import com.sps.covoid.tracker.form.LoginForm;
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

    /**
     * Login boolean.
     *
     * @return the boolean
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm")final LoginForm loginForm,
                        final Model model) {
        if ("admin".equals(loginForm.getUserName())
        && "admin".equals(loginForm.getPassword())) {
            return "home";
        }
        model.addAttribute("invalidCredentails", true);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }
}
