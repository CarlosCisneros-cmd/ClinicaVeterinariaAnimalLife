package com.uisrael.apiALconsumo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Veterinario")
public class VeterinarioControlador {
	
      @GetMapping("/Nuevo")
	  public String formulario() {
	        return "Veterinario/GuardarVeterinario"; 
	    }
      @GetMapping("/Listar")
      public String listarVeterinarios() {
          return "Veterinario/Listarveterinario";
      }
  }

