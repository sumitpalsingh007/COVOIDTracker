package com.sps.covoid.tracker.controller;

import com.sps.covoid.tracker.services.EntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StateWiseCovoidStatsController {

    final EntityService entityService;

    public StateWiseCovoidStatsController(final EntityService entityService) {
        this.entityService = entityService;
    }

    @RequestMapping(value = "/stateWiseData", method = RequestMethod.GET)
    public String messages1(Model model) {
        model.addAttribute("stateWiseData", entityService.getStateWiseCoronaData());
        return "home";
    }
}
