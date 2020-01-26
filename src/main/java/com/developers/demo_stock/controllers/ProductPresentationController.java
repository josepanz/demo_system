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

import com.developers.demo_stock.entity.ProductPresentation;

import com.developers.demo_stock.service.ProductPresentationService;

@Controller
@SessionAttributes("productPresentation")
public class ProductPresentationController {

    @Autowired
    private ProductPresentationService productPresentationService;

    @GetMapping("/productPresentation")
    public String productPresentation(Model model) {
        model.addAttribute("productPresentationList", productPresentationService.getAllProductPresentation());
        model.addAttribute("title", "Presentation de Producto");
        return "productPresentation/productPresentation";
    }

    @GetMapping("/addProductPresentation")
    public String getProductPresentation(Map<String, Object> model) {
        ProductPresentation productPresentation = new ProductPresentation();
        model.put("productSizeIterable", productPresentationService.findAllProductSize());
        model.put("productColorIterable", productPresentationService.findAllProductColor());
        model.put("productFamilyIterable", productPresentationService.findAllProductFamily());
        model.put("productBrandIterable", productPresentationService.findAllProductBrand());
        model.put("productIterable", productPresentationService.findAllProduct());
        model.put("productPresentation", productPresentation);
        model.put("title", "Agregar Presentacion de Producto");
        return "productPresentation/addProductPresentation";
    }

    @PostMapping("/addProductPresentation")
    public String postProductPresentation(@Valid @ModelAttribute("productPresentation") ProductPresentation productPresentation, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
                System.out.println(" ***** A ********");

        model.addAttribute("title", "Agregar Presentacion de Producto");
        model.addAttribute("productSizeIterable", productPresentationService.findAllProductSize());
        model.addAttribute("productColorIterable", productPresentationService.findAllProductColor());
        model.addAttribute("productFamilyIterable", productPresentationService.findAllProductFamily());
        model.addAttribute("productBrandIterable", productPresentationService.findAllProductBrand());
        model.addAttribute("productIterable", productPresentationService.findAllProduct());
        if (result.hasErrors()) {
            System.out.println("error in postProductPresentation: "+result);
            return "productPresentation/addProductPresentation";
        }
        try {
            productPresentationService.save(productPresentation);
            status.setComplete();
            flash.addFlashAttribute("success", "Presentacion de Producto agregado con éxito!");
        } catch (Exception e) {
            System.out.println("catch in postProductPresentation");
            model.addAttribute("error", e.getMessage());
            return "productPresentation/addProductPresentation";
        }
                System.out.println(" ***** B ********");

        return "redirect:/addProductPresentation";
    }

    @GetMapping("/editProductPresentation/{id}")
    public String getEditProductPresentation(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<ProductPresentation> productPresentation = productPresentationService.findById(id);
        model.put("productSizeIterable", productPresentationService.findAllProductSize());
        model.put("productColorIterable", productPresentationService.findAllProductColor());
        model.put("productFamilyIterable", productPresentationService.findAllProductFamily());
        model.put("productBrandIterable", productPresentationService.findAllProductBrand());
        model.put("productIterable", productPresentationService.findAllProduct());
        model.put("title", "Editar Presentation Producto");
        model.put("productPresentation", productPresentation);
        return "productPresentation/editProductPresentation";
    }

    @PostMapping("/editProductPresentation")
    public String putEditProductPresentation(@Valid ProductPresentation productPresentation, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        model.addAttribute("title", "Editar Presentation Producto");
        model.addAttribute("productSizeIterable", productPresentationService.findAllProductSize());
        model.addAttribute("productColorIterable", productPresentationService.findAllProductColor());
        model.addAttribute("productFamilyIterable", productPresentationService.findAllProductFamily());
        model.addAttribute("productBrandIterable", productPresentationService.findAllProductBrand());
        model.addAttribute("productIterable", productPresentationService.findAllProduct());
        if (result.hasErrors()) {
            return "productPresentation/editProductPresentation";
        }
        try {
            productPresentationService.save(productPresentation);
            status.setComplete();
            flash.addFlashAttribute("success", "Presentacion de Producto editado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "productPresentation/editProductPresentation";
        }
        return "redirect:/productPresentation";
    }

    @GetMapping("/deleteProductPresentation/{id}")
    public String deleteProductPresentation(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            productPresentationService.delete(id);
            flash.addFlashAttribute("success", "Presentacion de Producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productPresentation";
    }

}
