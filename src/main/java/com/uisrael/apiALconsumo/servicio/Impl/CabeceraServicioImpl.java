package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.CabeceraRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.CabeceraResponseDto;
import com.uisrael.apiALconsumo.servicio.ICabeceraServicio;

@Service
public class CabeceraServicioImpl implements ICabeceraServicio{
	
	private final WebClient webcliente;
	
	public CabeceraServicioImpl(WebClient webcliente) {
		super();
		this.webcliente = webcliente;
	}

	@Override
	public List<CabeceraResponseDto> Listarcabecera() {
		return webcliente.get().uri("/cabecera").retrieve().bodyToFlux(CabeceraResponseDto.class).collectList().block();
	}

	@Override
	public void crearCabecera(CabeceraRequestDto dto) {
		webcliente.post().uri("/cabecera").bodyValue(dto).retrieve().toBodilessEntity().block();
		
	}

}
