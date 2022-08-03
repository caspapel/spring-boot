package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController { 
	 
	@Value("${texto.index.titulo}")
	private String textoIndex;
	
	@GetMapping(value={"/index","/",""})
	public String index(Model model) {
		model.addAttribute("titulo", "titulo desde java con cambios en feature de prueba"); 
		return "index" ;
	}
	  
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("test");
		usuario.setApellido("apellido");
		model.addAttribute("usuario", usuario); 
		model.addAttribute("titulo", "Hola ".concat(usuario.getNombre())); 
		return "perfil";
	}
	  
	 
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de usuarios"); 
		return "listar";
	}
	
	
	@ModelAttribute("usuarios")
	public List<Usuario> cargarUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("usu1","usu1ape","1@e.com"));
		usuarios.add(new Usuario("usu2","usu2ape","2@e.com"));
		usuarios.add(new Usuario("usu3","usu3ape","3@e.com"));
		return usuarios;
	} 

}
