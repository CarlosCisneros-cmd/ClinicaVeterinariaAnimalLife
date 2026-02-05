package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.DetallesRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.DetallesResponseDto;
import com.uisrael.apiALconsumo.servicio.IDetallesServicio;


@Service
public class DetallesServicioImpl implements IDetallesServicio {
	
	
	private final WebClient webClient;

    
    public DetallesServicioImpl(WebClient webClient) {
        this.webClient = webClient;
        
    }
        @Override
    	public List<DetallesResponseDto> listarDetalles() {
    		return webClient.get().uri("/detalles") .retrieve().bodyToFlux(DetallesResponseDto.class).collectList().block();
    	}

    	@Override
    	public void crearDetalles(DetallesRequestDto dto) {
    		webClient.post().uri("/detalles") .bodyValue(dto).retrieve().toBodilessEntity().block();
    	}
        
        
        public DetallesResponseDto buscarDetallePorId(Integer id) {
            return webClient.get().uri("/detalles/{id}", id).retrieve().bodyToMono(DetallesResponseDto.class).block();
        }
        @Override
        public DetallesResponseDto buscarPorId(int id) {
            return webClient.get().uri("/detalles/{id}", id).retrieve().bodyToMono(DetallesResponseDto.class).block();
        }
		@Override
		public void eliminarDetalle(int id) {
			// TODO Auto-generated method stub
			
		}
			
			

}
