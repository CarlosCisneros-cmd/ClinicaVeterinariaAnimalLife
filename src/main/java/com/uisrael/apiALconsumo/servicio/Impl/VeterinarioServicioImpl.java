package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.VeterinarioResponseDto;
import com.uisrael.apiALconsumo.servicio.IVeterinarioServicio;

@Service
public class VeterinarioServicioImpl implements IVeterinarioServicio{
	
	private WebClient webcliente;

	public VeterinarioServicioImpl(WebClient webcliente) {
		super();
		this.webcliente = webcliente;
		
	}

	@Override
	public void crearVeterinario(VeterinarioRequestDto dto) {
		webcliente.post().uri("/veterinario").bodyValue(dto).retrieve().toBodilessEntity().block();
	}

	@Override
	public List<VeterinarioResponseDto> listarVeterinario() {
		return webcliente.get().uri("/veterinario").retrieve().bodyToFlux(VeterinarioResponseDto.class).collectList().block();
	}

	@Override
	public void eliminarVeterinario(int id) {
		webcliente.delete().uri("/veterinario/{id}", id) .retrieve().toBodilessEntity().block();
		
	}
		
}



