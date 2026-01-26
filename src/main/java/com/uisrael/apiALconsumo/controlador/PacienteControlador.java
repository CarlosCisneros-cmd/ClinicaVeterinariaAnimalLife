package com.uisrael.apiALconsumo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Paciente")
public class PacienteControlador {
	
	@GetMapping
	public String Guardarpaciente() {
		return "Paciente/GuardarPaciente";
		
	}
	
	@GetMapping("/Mostrarpaciente")
	public String Mostrarpaciente() {
		return "Paciente/Mostrarpaciente";
	}
		
	@GetMapping("/Listarpaciente")
	public String Listarpaciente() {
		return "Paciente/Listarpaciente";
	}

}
