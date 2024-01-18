package com.jedco.jedcoinspectionspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReactController {
    @GetMapping("/inspection")
    public ModelAndView inspection(){
        return new ModelAndView("forward:/inspection/index.html");
    }
    @GetMapping("/inspection_sales")
    public ModelAndView sales(){
        return new ModelAndView("forward:/inspection_sales/index.html");
    }
    @GetMapping("/inspection_legal")
    public ModelAndView legal(){
        return new ModelAndView("forward:/inspection_legal/index.html");
    }
}
