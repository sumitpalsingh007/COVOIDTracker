package com.sps.covoid.tracker.controller;

import com.sps.covoid.tracker.form.LoginForm;
import com.sps.covoid.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Login controller.
 */
@Controller
public class LoginController {

    /**
     * The User repository.
     */
    final UserRepository userRepository;

    /**
     * Instantiates a new Login controller.
     *
     * @param userRepository the user repository
     */
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Login.
     *
     * @param loginForm the login form
     * @param model     the model
     * @param response  the response
     * @return the String
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm")final LoginForm loginForm,
                        final Model model, final HttpServletResponse response) {
        final Cookie cookie;
        if (null != userRepository.getIdForExistingUser(
                loginForm.getUserName(), loginForm.getPassword())) {
            cookie = new Cookie("login", "true");
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
            return "home";
        }
        cookie = new Cookie("login", "false");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
        model.addAttribute("invalidCredentials", true);
        return "login";
    }

    /**
     * Gets login form.
     *
     * @return the login form
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }
}
