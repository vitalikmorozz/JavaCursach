package edu.stas.cursach.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WEBController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String mainPage() {
        return "pages/mainPage";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    String accessDeniedPage() {
        return "pages/accessDenied";
    }
}
