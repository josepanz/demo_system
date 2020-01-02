package com.developers.demo_stock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
@GetMapping("/login")
public String login() {
	return "login/login";
}

@GetMapping("/Content1")
public String Content1() {
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
