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

import com.developers.demo_stock.entity.ProductSize;
import com.developers.demo_stock.service.ProductSizeService;

@Controller
@SessionAttributes("productSize")
public class ProductSizeController {

    @Autowired
    private ProductSizeService productSizeService;

    @GetMapping("/productSize")
    public String productSize(Model model) {
        model.addAttribute("productSizeList", productSizeService.getAllProductSize());
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.addAttribute("title", "Tamano de Producto");
        return "productSize/productSize";
    }

    @GetMapping("/addProductSize")
    public String getProductSize(Map<String, Object> model) {
        ProductSize productSize = new ProductSize();
        /* formulario objeto de productSize */
        model.put("productSize", productSize);
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.put("title", "Agregar Tamano de Producto");

        return "productSize/addProductSize";
    }

    @PostMapping("/addProductSize")
    public String postProductSize(@Valid @ModelAttribute("productSize") ProductSize productSize, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Tamano de Producto");
        if (result.hasErrors()) {
            return "productSize/addProductSize";
        }
        try {

            productSizeService.save(productSize);
            status.setComplete();
            flash.addFlashAttribute("success", "Pais agregado con éxito!");

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "productSize/addProductSize";
        }
        return "redirect: addProductSize";
    }

    @GetMapping("/editProductSize/{id}")
    public String getEditProductSize(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<ProductSize> productSize = productSizeService.findById(id);
        System.out.println(productSize.toString());
        model.put("title", "Editar Tamano de Producto");
        model.put("productSize", productSize);
        System.err.println("id recuperado en getmappint edit" + productSize.get().getId());
        return "productSize/editProductSize";
    }

    @PostMapping("/editProductSize")
    public String putEditProductSize(@Valid ProductSize productSize, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Tamano Producto");
            return "productSize/editProductSize";
        }
        try {
            productSizeService.save(productSize);
            status.setComplete();
            flash.addFlashAttribute("success", "Tamano de Producto editado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productSize";
    }

    @GetMapping("/deleteProductSize/{id}")
    public String deleteProductSize(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            productSizeService.delete(id);
            flash.addFlashAttribute("success", "Tamano de Producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productSize";
    }

}
