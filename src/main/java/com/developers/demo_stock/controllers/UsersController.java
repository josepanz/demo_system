package com.developers.demo_stock.controllers;

import java.util.Map;
import java.util.Optional;

import javax.sound.midi.Soundbank;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.developers.demo_stock.entity.Person;
import com.developers.demo_stock.entity.Users;

import com.developers.demo_stock.service.UsersServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@SessionAttributes("users")
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;
    

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        model.addAttribute("title", "Usuario");
        return "users/users";
    }

    @GetMapping("/addUsers")
    public String getUsers(Map<String, Object> model) {
        Users users = new Users();
        model.put("personIterable", usersService.findAllPerson());
        model.put("users", users);
        model.put("title", "Agregar Usuario");
        return "users/addUsers";
    }

    @PostMapping("/addUsers")
    public String postUsers(@Valid @ModelAttribute("users") Users users, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Usuario");
        model.addAttribute("personIterable", usersService.findAllPerson());
        if (result.hasErrors()) {
            return "users/addUsers";
        }
        try {
            usersService.save(users);
            status.setComplete();
            flash.addFlashAttribute("success", "Usuario agregado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "users/addUsers";
        }
        return "redirect:/addUsers";
    }

    @GetMapping("/editUsers/{id}")
    public String getEditUsers(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<Users> users = usersService.findById(id);
        model.put("personIterable", usersService.findAllPerson());
        model.put("title", "Editar Usuario");
        model.put("users", users);
        return "users/editUsers";
    }

    @PostMapping("/editUsers")
    public String putEditUsers(@Valid Users users, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        model.addAttribute("title", "Editar Usuario");
        model.addAttribute("personIterable", usersService.findAllPerson());
        if (result.hasErrors()) {
            return "users/editUsers";
        }
        try {
            usersService.save(users);
            status.setComplete();
            flash.addFlashAttribute("success", "Usuario editado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "users/editUsers";
        }
        return "redirect:/users";
    }

    @GetMapping("/deleteUsers/{id}")
    public String deleteUsers(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            usersService.delete(id);
            flash.addFlashAttribute("success", "Usuario eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/users";
    }

}
