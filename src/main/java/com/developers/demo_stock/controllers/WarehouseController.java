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

import com.developers.demo_stock.entity.Warehouse;

import com.developers.demo_stock.service.WarehouseService;

@Controller
@SessionAttributes("warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/warehouse")
    public String warehouse(Model model) {
        model.addAttribute("warehouseList", warehouseService.getAllWarehouse());
        model.addAttribute("title", "Deposito");
        return "warehouse/warehouse";
    }

    @GetMapping("/addWarehouse")
    public String getWarehouse(Map<String, Object> model) {
        Warehouse warehouse = new Warehouse();
        model.put("companyBranchIterable", warehouseService.findAllCompanyBranch());
        model.put("warehouse", warehouse);
        model.put("title", "Agregar Deposito");
        return "warehouse/addWarehouse";
    }

    @PostMapping("/addWarehouse")
    public String postWarehouse(@Valid @ModelAttribute("warehouse") Warehouse warehouse, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Deposito");
        model.addAttribute("companyBranchIterable", warehouseService.findAllCompanyBranch());
        if (result.hasErrors()) {
            System.out.println("error in postWarehouse: "+result);
            return "warehouse/addWarehouse";
        }
        try {
            warehouseService.save(warehouse);
            status.setComplete();
            flash.addFlashAttribute("success", "Deposito agregado con éxito!");
        } catch (Exception e) {
            System.out.println("catch in postWarehouse");
            model.addAttribute("error", e.getMessage());
            return "warehouse/addWarehouse";
        }
        return "redirect:/addWarehouse";
    }

    @GetMapping("/editWarehouse/{id}")
    public String getEditWarehouse(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<Warehouse> warehouse = warehouseService.findById(id);
        model.put("companyBranchIterable", warehouseService.findAllCompanyBranch());
        model.put("title", "Editar Deposito");
        model.put("warehouse", warehouse);
        return "warehouse/editWarehouse";
    }

    @PostMapping("/editWarehouse")
    public String putEditWarehouse(@Valid Warehouse warehouse, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        model.addAttribute("title", "Editar Deposito");
        model.addAttribute("companyBranchIterable", warehouseService.findAllCompanyBranch());
        if (result.hasErrors()) {
            return "warehouse/editWarehouse";
        }
        try {
            warehouseService.save(warehouse);
            status.setComplete();
            flash.addFlashAttribute("success", "Deposito editado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "warehouse/editWarehouse";
        }
        return "redirect:/warehouse";
    }

    @GetMapping("/deleteWarehouse/{id}")
    public String deleteWarehouse(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            warehouseService.delete(id);
            flash.addFlashAttribute("success", "Deposito eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/warehouse";
    }

}
