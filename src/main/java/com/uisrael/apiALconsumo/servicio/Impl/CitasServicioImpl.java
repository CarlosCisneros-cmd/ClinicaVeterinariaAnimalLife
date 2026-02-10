package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.CitasRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.CitasResponseDto;
import com.uisrael.apiALconsumo.servicio.ICitasServicio;

import reactor.core.publisher.Mono;

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
        webcliente.post()
            .uri("/citas")
            .bodyValue(cita)
            .retrieve()
            .onStatus(status -> status.is4xxClientError(), response -> 
                response.bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                    .flatMap(errorBody -> {
                      
                        String mensaje = "Error al procesar la cita";
                        
                        
                        if (errorBody.containsKey("mensaje")) {
                            mensaje = errorBody.get("mensaje").toString();
                        } 
                        
                        else if (errorBody.containsKey("fecha_Hora")) {
                            mensaje = errorBody.get("fecha_Hora").toString();
                        }
                      
                        else if (errorBody.containsKey("fechaHora")) {
                            mensaje = errorBody.get("fechaHora").toString();
                        }
                        
                        return Mono.error(new RuntimeException(mensaje));
                    })
            )
            .bodyToMono(Void.class)
            .block();
    }

    @Override
    public void eliminarCita(int id) {
        webcliente.delete()
            .uri("/citas/{id}", id)
            .retrieve()
            .toBodilessEntity()
            .block();
    }

    @Override
    public CitasResponseDto buscarPorId(int idCita) {
        return webcliente.get()
                .uri(uriBuilder -> uriBuilder.path("/citas/buscarid/{idCita}")
                .build(idCita))
                .retrieve()
                .bodyToMono(CitasResponseDto.class)
                .block();
    }
}