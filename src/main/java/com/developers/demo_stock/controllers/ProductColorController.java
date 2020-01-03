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

import com.developers.demo_stock.entity.ProductColor;
import com.developers.demo_stock.service.ProductColorService;

@Controller
@SessionAttributes("productColor")
public class ProductColorController {

    @Autowired
    private ProductColorService productColorService;

    @GetMapping("/productColor")
    public String productColor(Model model) {
        model.addAttribute("productColorList", productColorService.getAllProductColor());
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.addAttribute("title", "Color de Producto");
        return "productColor/productColor";
    }

    @GetMapping("/addProductColor")
    public String getProductColor(Map<String, Object> model) {
        ProductColor productColor = new ProductColor();
        /* formulario objeto de productColor */
        model.put("productColor", productColor);
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.put("title", "Agregar Color de Producto");

        return "productColor/addProductColor";
    }

    @PostMapping("/addProductColor")
    public String postProductColor(@Valid @ModelAttribute("productColor") ProductColor productColor, BindingResult result, Model model,
            SessionStatus status) {
        model.addAttribute("title", "Agregar Color de Producto");
        if (result.hasErrors()) {
            return "productColor/addProductColor";
        }
        try {

            productColorService.save(productColor);
            status.setComplete();
            model.addAttribute("success", "Color de Producto agregado con éxito!");
            model.addAttribute("productColor", new ProductColor());

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "productColor/addProductColor";
    }

    @GetMapping("/editProductColor/{id}")
    public String getEditProductColor(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<ProductColor> productColor = productColorService.findById(id);
        System.out.println(productColor.toString());
        model.put("title", "Editar Color de Producto");
        model.put("productColor", productColor);
        System.err.println("id recuperado en getmappint edit" + productColor.get().getId());
        return "productColor/editProductColor";
    }

    @PostMapping("/editProductColor")
    public String putEditProductColor(@Valid ProductColor productColor, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Color Producto");
            return "productColor/editProductColor";
        }
        try {
            productColorService.save(productColor);
            status.setComplete();
            flash.addFlashAttribute("success", "Color de Producto editado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productColor";
    }

    @GetMapping("/deleteProductColor/{id}")
    public String deleteProductColor(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            productColorService.delete(id);
            flash.addFlashAttribute("success", "Color de Producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productColor";
    }

}
