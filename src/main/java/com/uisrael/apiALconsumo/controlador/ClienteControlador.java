package com.uisrael.apiALconsumo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.apiALconsumo.modelo.dto.response.ClienteResponseDto;
import com.uisrael.apiALconsumo.servicio.IClienteServicio;

@Controller
@RequestMapping("/Cliente")
public class ClienteControlador {
	
	@Autowired
	private IClienteServicio servicioCliente;
	
	
	@GetMapping
	public String Guardarcliente() {
		return "Cliente/Guardarcliente";
		
	}
	
	@GetMapping("/Listarcliente")
	public String Listarcliente(Model model ) {
		List<ClienteResponseDto> datosBase = servicioCliente.listarClientes();
		model.addAttribute("listarclientes",datosBase);
		return "Cliente/Listarcliente";
		
	}

}
