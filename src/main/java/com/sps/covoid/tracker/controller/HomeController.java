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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Home controller.
 */
@Controller
public class HomeController {

    /**
     * Gets home page.
     *
     * @param request the request
     * @return the home page
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (int i = 0; i < request.getCookies().length; i++) {
                if ("login".equals(request.getCookies()[i].getName())
                        && "true".equals(request.getCookies()[i].getValue())) {
                    return "home";
                }
            }
        }
        return "login";
    }
}
