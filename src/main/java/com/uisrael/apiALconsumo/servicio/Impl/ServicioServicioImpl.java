package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.ServicioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ServicioResponseDto;
import com.uisrael.apiALconsumo.servicio.IServicioServicio;

@Service
public class ServicioServicioImpl implements IServicioServicio{
	
	private final WebClient webcliente;

    
    public ServicioServicioImpl(WebClient webClient) {
        this.webcliente = webClient;
    }

    @Override
    public List<ServicioResponseDto> listarServicio() {
        return webcliente.get().uri("/servicios").retrieve().bodyToFlux(ServicioResponseDto.class).collectList().block();
    }

    @Override
    public void crearServicio(ServicioRequestDto dto) {
        webcliente.post().uri("/servicios").bodyValue(dto).retrieve().toBodilessEntity().block();
    }

    @Override
    public void eliminarServicio(int id) {
        
        webcliente.delete().uri("/servicios/{id}", id).retrieve().toBodilessEntity().block();
    }

	@Override
	public ServicioResponseDto buscarPorId(int idServicio) {
		return webcliente.get().uri(uriBuilder -> uriBuilder.path("/servicios/buscarid/{idServicio}")
				.build(idServicio)).retrieve().bodyToMono(ServicioResponseDto.class).block();
	}
}
