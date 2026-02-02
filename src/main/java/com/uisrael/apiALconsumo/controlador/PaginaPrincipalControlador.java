package com.uisrael.apiALconsumo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/PaginaPrincipal")
public class PaginaPrincipalControlador {
	
		@GetMapping
		public String index() {
			return "PaginaPrincipal/index";
			
		}
		 @GetMapping("/index")
		    public String mostrarPrincipal(HttpSession session) {
		        if (session.getAttribute("usuario") == null) {
		            return "redirect:/login";
		        }
		        return "Principal/principal";
		    }
		}