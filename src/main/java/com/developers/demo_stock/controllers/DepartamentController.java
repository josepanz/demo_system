package com.developers.demo_stock.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.developers.demo_stock.entity.Departament;
import com.developers.demo_stock.service.DepartamentService;

@Controller
@SessionAttributes("departament")
public class DepartamentController {
	@Autowired
	private DepartamentService departamentService;
    
	@GetMapping("/departament")
    public String departament(Model model) {
	model.addAttribute("departamentList", departamentService.getAllDepartament());
    model.addAttribute("title", "Departamento");
	return "departament/departament";
}
	@GetMapping("/addDepartament")
	public String getCountry(Map<String, Object> model) {
		Departament departament = new Departament();
		model.put("departament", departament);
		model.put("title", "Agregar Departamento");		
		return "departament/addDepartament";
	}


}
