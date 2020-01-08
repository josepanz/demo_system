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

import com.developers.demo_stock.entity.Product;

import com.developers.demo_stock.service.ProductService;

@Controller
@SessionAttributes("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("productList", productService.getAllProduct());
        model.addAttribute("title", "Producto");
        return "product/product";
    }

    @GetMapping("/addProduct")
    public String getMeasuredUnit(Map<String, Object> model) {
        Product product = new Product();
        model.put("measuredUnitIterable", productService.findAllMeasuredUnit());
        model.put("product", product);
        model.put("title", "Agregar Producto");
        return "product/addProduct";
    }

    @PostMapping("/addProduct")
    public String postMeasuredUnit(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Producto");
        model.addAttribute("measuredUnitIterable", productService.findAllMeasuredUnit());
        if (result.hasErrors()) {
            return "product/addProduct";
        }
        try {
            productService.save(product);
            status.setComplete();
            flash.addFlashAttribute("success", "Producto agregado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "product/addProduct";
        }
        return "redirect:/addProduct";
    }

    @GetMapping("/editProduct/{id}")
    public String getEditMeasuredUnit(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<Product> product = productService.findById(id);
        model.put("measuredUnitIterable", productService.findAllMeasuredUnit());
        model.put("title", "Editar Producto");
        model.put("product", product);
        return "product/editProduct";
    }

    @PostMapping("/editProduct")
    public String putEditMeasuredUnit(@Valid Product product, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        model.addAttribute("title", "Editar Producto");
        model.addAttribute("measuredUnitIterable", productService.findAllMeasuredUnit());
        if (result.hasErrors()) {
            return "product/editProduct";
        }
        try {
            productService.save(product);
            status.setComplete();
            flash.addFlashAttribute("success", "Producto editado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "product/editProduct";
        }
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteMeasuredUnit(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            productService.delete(id);
            flash.addFlashAttribute("success", "Producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/product";
    }

 /*   @GetMapping("/addProduct")
    public String getProductVat(Map<String, Object> model) {
        Product product = new Product();
        model.put("productVatIterable", productService.findAllProductVat());
        model.put("product", product);
        model.put("title", "Agregar Producto");
        return "product/addProduct";
    }

    @PostMapping("/addProduct")
    public String postProductVat(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
            SessionStatus status, RedirectAttributes flash) {
        model.addAttribute("title", "Agregar Producto");
        model.addAttribute("productVatIterable", productService.findAllProductVat());
        if (result.hasErrors()) {
            return "product/addProduct";
        }
        try {
            productService.save(product);
            status.setComplete();
            flash.addFlashAttribute("success", "Producto agregado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "product/addProduct";
        }
        return "redirect:/addProduct";
    }

    @GetMapping("/editProduct/{id}")
    public String getEditProductVat(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<Product> product = productService.findById(id);
        model.put("productVatIterable", productService.findAllProductVat());
        model.put("title", "Editar Producto");
        model.put("product", product);
        return "product/editProduct";
    }

    @PostMapping("/editProduct")
    public String putEditProductVat(@Valid Product product, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        model.addAttribute("title", "Editar Producto");
        model.addAttribute("productVatIterable", productService.findAllProductVat());
        if (result.hasErrors()) {
            return "product/editProduct";
        }
        try {
            productService.save(product);
            status.setComplete();
            flash.addFlashAttribute("success", "Producto editado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "product/editProduct";
        }
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProductVat(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            productService.delete(id);
            flash.addFlashAttribute("success", "Producto eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/product";
    }
*/
}
