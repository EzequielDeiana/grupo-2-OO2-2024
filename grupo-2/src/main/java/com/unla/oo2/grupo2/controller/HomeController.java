package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/home/index");
    }

    @GetMapping("/")
    public RedirectView redirectHome() {
        return new RedirectView("/index");
    }

}
