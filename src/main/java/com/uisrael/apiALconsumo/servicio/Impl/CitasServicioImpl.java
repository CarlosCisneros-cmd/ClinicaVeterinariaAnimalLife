package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.apiALconsumo.modelo.dto.request.CitasRequestDto;

import com.uisrael.apiALconsumo.modelo.dto.response.CitasResponseDto;
import com.uisrael.apiALconsumo.servicio.ICitasServicio;

@Service
public class CitasServicioImpl implements ICitasServicio {

    @Autowired
    private WebClient webcliente;

    @Override
    public List<CitasResponseDto> listarCitas() {
        return webcliente.get()
                .uri("/citas")
                .retrieve()
                .bodyToFlux(CitasResponseDto.class)
                .collectList()
                .block();
    }

    @Override
    public void crearCita(CitasRequestDto cita) {
        
        webcliente.post().uri("/citas").bodyValue(cita).retrieve().bodyToMono(Void.class).block();
    }
    @Override
	public void eliminarCita(int id) {
	    webcliente.delete().uri("/citas/{id}", id).retrieve().toBodilessEntity().block();
	}

	@Override
	public CitasResponseDto buscarPorId(int idCita) {
		return webcliente.get().uri(uriBuilder -> uriBuilder.path("/citas/buscarid/{idCita}")
				.build(idCita)).retrieve().bodyToMono(CitasResponseDto.class).block();
	}
}