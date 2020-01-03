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

import com.developers.demo_stock.entity.ProductBrand;
import com.developers.demo_stock.service.ProductBrandService;

@Controller
@SessionAttributes("productBrand")
public class ProductBrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @GetMapping("/productBrand")
    public String productBrand(Model model) {
        model.addAttribute("productBrandList", productBrandService.getAllProductBrand());
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.addAttribute("title", "Marca de Producto");
        return "productBrand/productBrand";
    }

    @GetMapping("/addProductBrand")
    public String getProductBrand(Map<String, Object> model) {
        ProductBrand productBrand = new ProductBrand();
        /* formulario objeto de productBrand */
        model.put("productBrand", productBrand);
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.put("title", "Agregar Marca de Producto");

        return "productBrand/addProductBrand";
    }

    @PostMapping("/addProductBrand")
    public String postProductBrand(@Valid @ModelAttribute("productBrand") ProductBrand productBrand, BindingResult result, Model model,
            SessionStatus status) {
        model.addAttribute("title", "Agregar Marca de Producto");
        if (result.hasErrors()) {
            return "productBrand/addProductBrand";
        }
        try {

            productBrandService.save(productBrand);
            status.setComplete();
            model.addAttribute("success", "Marca de Producto agregado con éxito!");
            model.addAttribute("productBrand", new ProductBrand());

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "productBrand/addProductBrand";
    }

    @GetMapping("/editProductBrand/{id}")
    public String getEditProductBrand(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<ProductBrand> productBrand = productBrandService.findById(id);
        System.out.println(productBrand.toString());
        model.put("title", "Editar Marca de Producto");
        model.put("productBrand", productBrand);
        System.err.println("id recuperado en getmappint edit" + productBrand.get().getId());
        return "productBrand/editProductBrand";
    }

    @PostMapping("/editProductBrand")
    public String putEditProductBrand(@Valid ProductBrand productBrand, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Marca Producto");
            return "productBrand/editProductBrand";
        }
        try {
            productBrandService.save(productBrand);
            status.setComplete();
            flash.addFlashAttribute("success", "Marca de Producto editado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productBrand";
    }

    @GetMapping("/deleteProductBrand/{id}")
    public String deleteProductBrand(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            productBrandService.delete(id);
            flash.addFlashAttribute("success", "Marca de Producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/productBrand";
    }

}
