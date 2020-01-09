package com.developers.demo_stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.developers.demo_stock.service.CityService;

@Controller
@SessionAttributes("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public String city(Model model) {
        model.addAttribute("cityList", cityService.getAllCity());
        model.addAttribute("title", "Ciudad");
        return "city/city";
    }
}
