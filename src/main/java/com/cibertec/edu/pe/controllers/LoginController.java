package com.cibertec.edu.pe.controllers;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class LoginController {
	@GetMapping("/login")
	public String login(@RequestParam(value="error",required = false)String error,
			@RequestParam(value="logout",required=false)String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		if(principal!=null) {
			flash.addFlashAttribute("info","Ya ha iniciado sessión anteriormente");
			return "redirect:/home/alumno";
		}
		if(error!=null) {
			model.addAttribute("error","Error en el login: Nombre de usuario o Contraseña incorrecta, porfavor vuelva a intentarlo!");
		}
		if(logout!=null) {
			model.addAttribute("success","Ha cerrado sessión con éxito");
		}
		return "login";
	}
}
