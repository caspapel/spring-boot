package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("titulo", "titulo desde java con cambios 2"); 
		return "index" ;
	}

}
