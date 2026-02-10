package com.uisrael.apiALconsumo.controlador;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.apiALconsumo.modelo.dto.request.ClienteRequestDto; 
import com.uisrael.apiALconsumo.modelo.dto.request.PacienteRequestDTO;
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

	@GetMapping("/Nuevo")
	public String Crearpaciente(@RequestParam int idCliente, Model model) {
		PacienteRequestDTO nuevo = new PacienteRequestDTO();
		nuevo.setFkCliente(new ClienteRequestDto());
		nuevo.getFkCliente().setIdCliente(idCliente); 
		model.addAttribute("paciente", nuevo);
		model.addAttribute("idCliente", idCliente);
		return "Paciente/Crearpaciente";
	}
	
	@GetMapping("/Mostrarpaciente")
	public String Mostrarpaciente(@RequestParam int idCliente, Model model) {
		model.addAttribute("idCliente", idCliente);
		List<PacienteResponseDTO> todasMascotas = servicioPaciente.Listarpaciente();
		List<PacienteResponseDTO> filtradas = todasMascotas.stream()
			.filter(p -> p.getFkCliente() != null && p.getFkCliente().getIdCliente() == idCliente)
			.collect(Collectors.toList());
		model.addAttribute("listaMascotas", filtradas);
		return "Paciente/Mostrarpaciente";
	}

	@PostMapping("/Guardar")
	public String Guardarpaciente(@ModelAttribute PacienteRequestDTO paciente, Model model) {
		try {
			servicioPaciente.crearPaciente(paciente);
			int id = (paciente.getFkCliente() != null) ? paciente.getFkCliente().getIdCliente() : 0;
			return "redirect:/Paciente/Mostrarpaciente?idCliente=" + id;
		} catch (RuntimeException e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("paciente", paciente);	
			int idCliente = (paciente.getFkCliente() != null) ? paciente.getFkCliente().getIdCliente() : 0;
			model.addAttribute("idCliente", idCliente);
			
			return "Paciente/Crearpaciente";
		}
	}
	
	@GetMapping("/Eliminar/{id}")
	public String eliminarPaciente(@PathVariable int id, @RequestParam(required = false) Integer idCliente) {
		servicioPaciente.eliminarPaciente(id);
		if (idCliente != null) {
			return "redirect:/Paciente/Mostrarpaciente?idCliente=" + idCliente;
		} else {
			return "redirect:/Paciente/Listarpaciente"; 
		}
	}
	
	@GetMapping("/buscar/{idPaciente}")
	public String editarPaciente(@PathVariable int idPaciente, Model model) {
		PacienteResponseDTO pac = servicioPaciente.buscarPorId(idPaciente);
		model.addAttribute("paciente", pac);
		if (pac != null && pac.getFkCliente() != null) {
			model.addAttribute("idCliente", pac.getFkCliente().getIdCliente());
		}
		return "Paciente/Crearpaciente";
	}
}