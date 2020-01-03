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

import com.developers.demo_stock.entity.Currency;
import com.developers.demo_stock.service.CurrencyService;

@Controller
@SessionAttributes("currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency")
    public String city(Model model) {
        model.addAttribute("currencyList", currencyService.getAllCurrency());
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.addAttribute("title", "Moneda");
        return "currency/currency";
    }

    @GetMapping("/addCurrency")
    public String getCurrency(Map<String, Object> model) {
        Currency currency = new Currency();
        /* formulario objeto de currency */
        model.put("currency", currency);
        /* para poner titulo pag. web titulo(se encuentra en el layout) */
        model.put("title", "Agregar Moneda");

        return "currency/addCurrency";
    }

    @PostMapping("/addCurrency")
    public String postCurrency(@Valid @ModelAttribute("currency") Currency currency, BindingResult result, Model model,
            SessionStatus status) {
        model.addAttribute("title", "Agregar Moneda");
        if (result.hasErrors()) {
            return "currency/addCurrency";
        }
        try {

            currencyService.save(currency);
            status.setComplete();
            model.addAttribute("success", "Moneda agregada con éxito!");
            model.addAttribute("currency", new Currency());

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "currency/addCurrency";
    }

    @GetMapping("/editCurrency/{id}")
    public String getEditCurrency(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Optional<Currency> currency = currencyService.findById(id);
        System.out.println(currency.toString());
        model.put("title", "Editar Moneda");
        model.put("currency", currency);
        System.err.println("id recuperado en getmappint edit" + currency.get().getId());
        return "currency/editCurrency";
    }

    @PostMapping("/editCurrency")
    public String putEditCurrency(@Valid Currency currency, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Moneda");
            return "currency/editCurrency";
        }
        try {
            currencyService.save(currency);
            status.setComplete();
            flash.addFlashAttribute("success", "Moneda editado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/currency";
    }

    @GetMapping("/deleteCurrency/{id}")
    public String deleteCurrency(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        try {
            currencyService.delete(id);
            flash.addFlashAttribute("success", "Moneda eliminado con éxito!");
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/currency";
    }

}
