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

import com.developers.demo_stock.entity.WarehouseStock;

import com.developers.demo_stock.service.WarehouseStockService;

@Controller
@SessionAttributes("warehouseStock")
public class WarehouseStockController {

    @Autowired
    private WarehouseStockService warehouseStockService;

    @GetMapping("/warehouseStock")
    public String product(Model model) {
        model.addAttribute("warehouseStockList", warehouseStockService.getAllWarehouseStock());
        model.addAttribute("title", "Deposito");
        return "warehouseStock/warehouseStock";
    }

    @GetMapping("/addWarehouseStock")
    public String getWarehouseStock(Map<String, Object> model) {
        WarehouseStock warehouseStock = new WarehouseStock();
        model.put("productPresentationIterable", warehouseStockService.findAllProductPresentation());
        model.put("warehouseIterable", warehouseStockService.findAllWarehouse());
        model.put("warehouseStock", warehouseStock);
        model.put("title", "Agregar Existencia del Producto al Deposito");
        return "warehouseStock/addWarehouseStock";
    }

    @PostMapping("/addWarehouseStock")
    public String postWarehouseStock(@Valid @ModelAttribute("warehouseStock") WarehouseStock warehouseStock, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Existencia del Producto al Deposito");
        model.addAttribute("productPresentationIterable", warehouseStockService.findAllProductPresentation());
        model.addAttribute("warehouseIterable", warehouseStockService.findAllWarehouse());
        if (result.hasErrors()) {
            System.out.println("error in postWarehouseStock: "+result);
            return "warehouseStock/addWarehouseStock";
        }
        try {
            warehouseStockService.save(warehouseStock);
            status.setComplete();
            flash.addFlashAttribute("success", "Existencia del producto agregado con éxito!");
        } catch (Exception e) {
            System.out.println("catch in postWarehouseStock");
            model.addAttribute("error", e.getMessage());
            return "warehouseStock/addWarehouseStock";
        }
        return "redirect:/addWarehouseStock";
    }

    @GetMapping("/editWarehouseStock/{id}")
    public String getEditWarehouseStock(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<WarehouseStock> warehouseStock = warehouseStockService.findById(id);
        model.put("productPresentationIterable", warehouseStockService.findAllProductPresentation());
        model.put("warehouseIterable", warehouseStockService.findAllWarehouse());
        model.put("title", "Editar Existencia del Producto al Deposito");
        model.put("warehouseStock", warehouseStock);
        return "warehouseStock/editWarehouseStock";
    }

    @PostMapping("/editWarehouseStock")
    public String putEditWarehouseStock(@Valid WarehouseStock warehouseStock, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        model.addAttribute("title", "Editar Existencia del Producto al deposito");
        model.addAttribute("productPresentationIterable", warehouseStockService.findAllProductPresentation());
        model.addAttribute("warehouseIterable", warehouseStockService.findAllWarehouse());
        if (result.hasErrors()) {
            return "warehouseStock/editWarehouseStock";
        }
        try {
            warehouseStockService.save(warehouseStock);
            status.setComplete();
            flash.addFlashAttribute("success", "Existencia del producto editado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "warehouseStock/editWarehouseStock";
        }
        return "redirect:/warehouseStock";
    }

    @GetMapping("/deleteWarehouseStock/{id}")
    public String deleteWarehouseStock(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            warehouseStockService.delete(id);
            flash.addFlashAttribute("success", "Existencia del producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/warehouseStock";
    }

}
