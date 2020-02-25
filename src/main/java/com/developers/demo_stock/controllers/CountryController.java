package com.developers.demo_stock.controllers;



import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.developers.demo_stock.entity.Country;
import com.developers.demo_stock.service.CountryService;
import com.developers.demo_stock.util.paginator.PageRender;

@Controller
@SessionAttributes("country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/country")
	public String city(Model model,@RequestParam(name = "page", defaultValue = "0") int page) {
		/*se pone el rango de resultado que queremos para paginar*/
		PageRequest pageRequest = PageRequest.of(page, 10);
		Page<Country> countryPage = countryService.findAll(pageRequest);
		PageRender<Country> pageRender = new PageRender<Country>("/country", countryPage);
		//model.addAttribute("countryList", countryService.getAllCountry());
		model.addAttribute("countryList", countryPage);
		/* para poner titulo pag. web titulo(se encuentra en el layout) */
		model.addAttribute("title", "País");
		model.addAttribute("page", pageRender);
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
			model.addAttribute("error", e.getMessage());
			return "country/addCountry";
		}
		return "redirect:/addCountry";
	}
	

	@GetMapping("/editCountry/{id}")
	public String getEditCountry(@PathVariable(value = "id") Integer id, Map<String, Object> model) {		
		Optional<Country> country= countryService.findById(id);
		model.put("title", "Editar Pais");
		model.put("country", country);
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
