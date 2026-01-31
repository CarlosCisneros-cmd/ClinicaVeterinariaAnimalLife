package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.uisrael.apiALconsumo.modelo.dto.request.PacienteRequestDTO;

import com.uisrael.apiALconsumo.modelo.dto.response.PacienteResponseDTO;
import com.uisrael.apiALconsumo.servicio.IPacienteServicio;



@Service
public class PacienteServicioImpl implements IPacienteServicio{
	private final WebClient webcliente;

	public PacienteServicioImpl(WebClient webcliente) {
		super();
		this.webcliente = webcliente;
	}
	
	@Override
	public List<PacienteResponseDTO> Listarpaciente() {
		return webcliente.get().uri("/pacientes").retrieve().bodyToFlux(PacienteResponseDTO.class).collectList().block();
	}

	@Override
	public void crearPaciente(PacienteRequestDTO dto) {
		webcliente.post().uri("/pacientes").bodyValue(dto).retrieve().toBodilessEntity().block();
		
	}

}
