package com.developers.demo_stock.controllers;

import java.util.Map;
import java.util.Optional;

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

import com.developers.demo_stock.entity.CivilStatus;
import com.developers.demo_stock.service.CivilStatusService;

@Controller
@SessionAttributes("civilStatus")
public class CivilStatusController {

    @Autowired
    private CivilStatusService civilStatusService;

    @GetMapping("/civilStatus")
    public String city(Model model) {
        model.addAttribute("civilStatusList", civilStatusService.getAllCivilStatus());
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.addAttribute("title", "Estado Civil");
        return "civilStatus/civilStatus";
    }

    @GetMapping("/addCivilStatus")
    public String getCivilStatus(Map<String, Object> model) {
        CivilStatus civilStatus = new CivilStatus();
        /* formulario objeto de civilStatus */
        model.put("civilStatus", civilStatus);
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.put("title", "Agregar Estado Civil");

        return "civilStatus/addCivilStatus";
    }

    @PostMapping("/addCivilStatus")
    public String postCivilStatus(@Valid @ModelAttribute("civilStatus") CivilStatus civilStatus, BindingResult result, Model model,
            SessionStatus status) {
        model.addAttribute("title", "Agregar Estado Civil");
        if (result.hasErrors()) {
            return "civilStatus/addCivilStatus";
        }
        try {

            civilStatusService.save(civilStatus);
            status.setComplete();
            model.addAttribute("success", "Estado Civil agregado con éxito!");
            model.addAttribute("civilStatus", new CivilStatus());

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "civilStatus/addCivilStatus";
    }

    @GetMapping("/editCivilStatus/{id}")
    public String getEditCivilStatus(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<CivilStatus> civilStatus = civilStatusService.findById(id);
        System.out.println(civilStatus.toString());
        model.put("title", "Editar Estado Civil");
        model.put("civilStatus", civilStatus);
        System.err.println("id recuperado en getmappint edit" + civilStatus.get().getId());
        return "civilStatus/editCivilStatus";
    }

    @PostMapping("/editCivilStatus")
    public String putEditCivilStatus(@Valid CivilStatus civilStatus, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Estado Civil");
            return "civilStatus/editCivilStatus";
        }
        try {
            civilStatusService.save(civilStatus);
            status.setComplete();
            flash.addFlashAttribute("success", "Estado Civil editado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/civilStatus";
    }

    @GetMapping("/deleteCivilStatus/{id}")
    public String deleteCivilStatus(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            civilStatusService.delete(id);
            flash.addFlashAttribute("success", "Estado Civil eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/civilStatus";
    }

}
