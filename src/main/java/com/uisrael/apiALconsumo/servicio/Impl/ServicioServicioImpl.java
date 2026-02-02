package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.ServicioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ServicioResponseDto;
import com.uisrael.apiALconsumo.servicio.IServicioServicio;

@Service
public class ServicioServicioImpl implements IServicioServicio{
	
	private final WebClient webClient;

    
    public ServicioServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<ServicioResponseDto> listarServicio() {
        return webClient.get().uri("/servicios").retrieve().bodyToFlux(ServicioResponseDto.class).collectList().block();
    }

    @Override
    public void crearServicio(ServicioRequestDto dto) {
        webClient.post().uri("/servicios").bodyValue(dto).retrieve().toBodilessEntity().block();
    }

}
