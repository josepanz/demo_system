package com.developers.demo_stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.developers.demo_stock.service.CityService;

@Controller
@SessionAttributes("city")
public class LoginController {
	  @Autowired
	    private CityService cityService;
    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/Content1")
    public String Content1(Model model) {
    	 model.addAttribute("cityList", cityService.getAllCity());
         model.addAttribute("title", "Ciudad");
        return "prueba/Content1";
    }

    @GetMapping("/index")
    public String Content2() {
        return "prueba/Content2";
    }

    @GetMapping
    public String page1() {
        return "page1";
    }

    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }

}
