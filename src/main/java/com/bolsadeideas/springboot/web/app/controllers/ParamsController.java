package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	@GetMapping("/")
	public String index() {

		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String param(@RequestParam(required = false) String texto, Model model) {
        model.addAttribute("resultado", "el resultado es " + texto);
		return "params/ver";
	}
	
	 
	@GetMapping("/mix-params")
	public String param(@RequestParam(required = false) String saludo, @RequestParam(required = false) Integer numero, Model model) {
        model.addAttribute("resultado", "el resultado es " + saludo + " el numero es " + numero);
		return "params/ver";
	}
	
	@GetMapping("/mix-params2")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = Integer.parseInt(request.getParameter("numero"));
        model.addAttribute("resultado", "el resultado es " + saludo + " el numero es " + numero);
		return "params/ver";
	}
}
