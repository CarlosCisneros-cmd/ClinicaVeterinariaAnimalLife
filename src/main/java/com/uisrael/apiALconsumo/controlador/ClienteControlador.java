package com.uisrael.apiALconsumo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.apiALconsumo.modelo.dto.request.ClienteRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ClienteResponseDto;
import com.uisrael.apiALconsumo.servicio.IClienteServicio;

@Controller
@RequestMapping("/Cliente")
public class ClienteControlador {
	
	@Autowired
	private IClienteServicio servicioCliente;
	
	
	@GetMapping
	public String Crearcliente(Model model) {
		model.addAttribute("cliente",new ClienteRequestDto());
		return "Cliente/Crearcliente";
		
	}
	
	@GetMapping("/Listarcliente")
	public String Listarcliente(Model model ) {
		List<ClienteResponseDto> datosBase = servicioCliente.listarClientes();
		model.addAttribute("listarclientes",datosBase);
		return "Cliente/Listarcliente";
		
	}
	@PostMapping("/Guardar")
	public String Guardarcliente(@ModelAttribute ClienteRequestDto cliente) {
		servicioCliente.crearCliente(cliente);
		return "redirect:/Cliente/Listarcliente";
		
	}
	

}
