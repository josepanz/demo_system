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

import com.developers.demo_stock.entity.ProductFamily;
import com.developers.demo_stock.service.ProductFamilyService;

@Controller
@SessionAttributes("productFamily")
public class ProductFamilyController {

    @Autowired
    private ProductFamilyService productFamilyService;

    @GetMapping("/productFamily")
    public String productFamily(Model model) {
        model.addAttribute("productFamilyList", productFamilyService.getAllProductFamily());
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.addAttribute("title", "Familia de Producto");
        return "productFamily/productFamily";
    }

    @GetMapping("/addProductFamily")
    public String getProductFamily(Map<String, Object> model) {
        ProductFamily productFamily = new ProductFamily();
        /* formulario objeto de productFamily */
        model.put("productFamily", productFamily);
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.put("title", "Agregar Familia de Producto");

        return "productFamily/addProductFamily";
    }

    @PostMapping("/addProductFamily")
    public String postProductFamily(@Valid @ModelAttribute("productFamily") ProductFamily productFamily, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Familia de Producto");
        if (result.hasErrors()) {
            return "productFamily/addProductFamily";
        }
        try {

            productFamilyService.save(productFamily);
            status.setComplete();
            flash.addFlashAttribute("success", "Familia de Producto agregado con éxito!");	

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "productFamily/addProductFamily";
        }
        return "redirect: addProductFamily";
    }

    @GetMapping("/editProductFamily/{id}")
    public String getEditProductFamily(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<ProductFamily> productFamily = productFamilyService.findById(id);
        System.out.println(productFamily.toString());
        model.put("title", "Editar Familia de Producto");
        model.put("productFamily", productFamily);
        System.err.println("id recuperado en getmappint edit" + productFamily.get().getId());
        return "productFamily/editProductFamily";
    }

    @PostMapping("/editProductFamily")
    public String putEditProductFamily(@Valid ProductFamily productFamily, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Familia Producto");
            return "productFamily/editProductFamily";
        }
        try {
            productFamilyService.save(productFamily);
            status.setComplete();
            flash.addFlashAttribute("success", "Familia de Producto editado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productFamily";
    }

    @GetMapping("/deleteProductFamily/{id}")
    public String deleteProductFamily(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            productFamilyService.delete(id);
            flash.addFlashAttribute("success", "Familia de Producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productFamily";
    }

}
