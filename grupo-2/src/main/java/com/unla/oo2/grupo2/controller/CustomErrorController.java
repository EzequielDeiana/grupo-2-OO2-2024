package com.unla.oo2.grupo2.controller;

import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping()
public class CustomErrorController implements ErrorController 
{
    
    @GetMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, Map<String, Object> model) 
    {
        ModelAndView modelAndView = new ModelAndView("/error/error");

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");

        model.put("statusCode", statusCode);
        model.put("errorMessage", errorMessage);

        modelAndView.addObject("statusCode", statusCode);
        modelAndView.addObject("errorMessage", errorMessage);

        return modelAndView;
    }
    
    public String getErrorPath() {
        return "/error";
    }

}
