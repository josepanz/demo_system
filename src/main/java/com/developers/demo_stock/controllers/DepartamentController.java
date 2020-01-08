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

import com.developers.demo_stock.entity.Country;
import com.developers.demo_stock.entity.Departament;

import com.developers.demo_stock.service.DepartamentService;

@Controller
@SessionAttributes("departament")
public class DepartamentController {

    @Autowired
    private DepartamentService departamentService;

    @GetMapping("/departament")
    public String departament(Model model) {
        model.addAttribute("departamentList", departamentService.getAllDepartament());
        model.addAttribute("title", "Departamento");
        return "departament/departament";
    }

    @GetMapping("/addDepartament")
    public String getCountry(Map<String, Object> model) {
        Departament departament = new Departament();
        model.put("countryIterable", departamentService.findAllCountry());
        model.put("departament", departament);
        model.put("title", "Agregar Departamento");
        return "departament/addDepartament";
    }

    @PostMapping("/addDepartament")
    public String postCountry(@Valid @ModelAttribute("departament") Departament departament, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Departamento");
        model.addAttribute("countryIterable", departamentService.findAllCountry());
        if (result.hasErrors()) {
            return "departament/addDepartament";
        }
        try {
            departamentService.save(departament);
            status.setComplete();
            flash.addFlashAttribute("success", "Departamento agregado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "departament/addDepartament";
        }
        return "redirect:/addDepartament";
    }

    @GetMapping("/editDepartament/{id}")
    public String getEditCountry(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<Departament> departament = departamentService.findById(id);
        model.put("countryIterable", departamentService.findAllCountry());
        model.put("title", "Editar Departamento");
        model.put("departament", departament);
        return "departament/editDepartament";
    }

    @PostMapping("/editDepartament")
    public String putEditCountry(@Valid Departament departament, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        model.addAttribute("title", "Editar Departamento");
        model.addAttribute("countryIterable", departamentService.findAllCountry());
        if (result.hasErrors()) {
            return "departament/editDepartament";
        }
        try {
            departamentService.save(departament);
            status.setComplete();
            flash.addFlashAttribute("success", "Departamento editado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "departament/editDepartament";
        }
        return "redirect:/departament";
    }

    @GetMapping("/deleteDepartament/{id}")
    public String deleteCountry(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            departamentService.delete(id);
            flash.addFlashAttribute("success", "Departamento eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/departament";
    }

}
