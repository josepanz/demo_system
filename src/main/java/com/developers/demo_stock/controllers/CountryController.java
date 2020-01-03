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
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.developers.demo_stock.entity.Country;
import com.developers.demo_stock.service.CountryService;

@Controller
@SessionAttributes("country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/country")
	public String city(Model model) {
		model.addAttribute("countryList", countryService.getAllCountry());
		/* para poner titulo pag. web titulo(se encuentra en el layout) */
		model.addAttribute("title", "País");
		return "country/country";
	}

	@GetMapping("/addCountry")
	public String getCountry(Map<String, Object> model) {
		Country country = new Country();
		/* formulario objeto de country */
		model.put("country", country);
		/* para poner titulo pag. web titulo(se encuentra en el layout) */
		model.put("title", "Agregar Pais");
		
		return "country/addCountry";
	}
	@PostMapping("/addCountry")
	public String postCountry(@Valid @ModelAttribute("country") Country country, BindingResult result, Model model,
			SessionStatus status, RedirectAttributes flash) {		
		model.addAttribute("title", "Agregar País");
		if (result.hasErrors()) {
			return "country/addCountry";
		}
		try {    
			countryService.save(country);
			status.setComplete();		
			flash.addFlashAttribute("success", "Pais agregado con éxito!");		
		} catch (Exception e) {
			flash.addFlashAttribute("error", e.getMessage());
		}
		return "redirect:/addCountry";
	}
	

	@GetMapping("/editCountry/{id}")
	public String getEditCountry(@PathVariable(value = "id") Integer id, Map<String, Object> model) {		
		Optional<Country> country= countryService.findById(id);
		System.out.println(country.toString());
		model.put("title", "Editar Pais");
		model.put("country", country);
		System.err.println("id recuperado en getmappint edit"+ country.get().getId());
		return "country/editCountry";
	}
	
	@PostMapping("/editCountry")
	public String putEditCountry(@Valid Country country, BindingResult result, Model model,
			 RedirectAttributes flash, SessionStatus status) {
      
		if (result.hasErrors()) {
			model.addAttribute("title", "Editar País");
			return "country/editCountry";
		}		
		try {
			countryService.save(country);            
			status.setComplete();		
			flash.addFlashAttribute("success", "Pais editado con éxito!");			
		} catch (Exception e) {
			flash.addFlashAttribute("error", e.getMessage());
		}
		return "redirect:/country";
	}

	@GetMapping("/deleteCountry/{id}")
	public String deleteCountry(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
		try {
			countryService.delete(id);
			flash.addFlashAttribute("success", "Pais eliminado con éxito!");
		} catch (Exception e) {
			flash.addFlashAttribute("error", e.getMessage());
		}
		return "redirect:/country";
	}

}
