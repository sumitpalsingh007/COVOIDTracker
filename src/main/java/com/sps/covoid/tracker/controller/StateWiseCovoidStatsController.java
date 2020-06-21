package com.sps.covoid.tracker.controller;

import com.sps.covoid.tracker.entities.StateStats;
import com.sps.covoid.tracker.services.EntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("controller")
public class StateWiseCovoidStatsController {

    final EntityService entityService;

    public StateWiseCovoidStatsController(final EntityService entityService) {
        this.entityService = entityService;
    }

    //@RequestMapping(value = "/stateWiseData", method = RequestMethod.GET)
    @ModelAttribute("stateWiseData")
    public List<StateStats> listStudent() {
        /*model.addAttribute("stats", entityService.getStateWiseCoronaData());
        return "home";*/
        return entityService.getStateWiseCoronaData();
    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("message/list");
        mav.addObject("messages", entityService.getStateWiseCoronaData());
        return mav;
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String messages1(Model model) {
        model.addAttribute("home", entityService.getStateWiseCoronaData());
        return "home";
    }
}
