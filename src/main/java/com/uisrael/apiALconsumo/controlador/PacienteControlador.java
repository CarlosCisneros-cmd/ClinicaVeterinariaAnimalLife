package com.uisrael.apiALconsumo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.uisrael.apiALconsumo.modelo.dto.response.PacienteResponseDTO;
import com.uisrael.apiALconsumo.servicio.IPacienteServicio;

@Controller
@RequestMapping("/Paciente")
public class PacienteControlador {
	
	@Autowired
	private IPacienteServicio servicioPaciente; 

	@GetMapping("/Listarpaciente")
	public String Listarpaciente(Model model) {
	
		List<PacienteResponseDTO> datosMascotas = servicioPaciente.Listarpaciente();
		
		model.addAttribute("listaMascotas", datosMascotas);
		
		return "Paciente/Listarpaciente"; 
	}

	@GetMapping
	public String Guardarpaciente() {
		return "Paciente/GuardarPaciente";
	}
	
	@GetMapping("/Mostrarpaciente")
	public String Mostrarpaciente() {
		return "Paciente/Mostrarpaciente";
	}
}