package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.PacienteRequestDTO;
import com.uisrael.apiALconsumo.modelo.dto.response.PacienteResponseDTO;
import com.uisrael.apiALconsumo.servicio.IPacienteServicio;

import reactor.core.publisher.Mono;

@Service
public class PacienteServicioImpl implements IPacienteServicio {

    private final WebClient webcliente;

    public PacienteServicioImpl(WebClient webcliente) {
        this.webcliente = webcliente;
    }

    @Override
    public List<PacienteResponseDTO> Listarpaciente() {
        return webcliente.get()
                .uri("/pacientes")
                .retrieve()
                .bodyToFlux(PacienteResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public void crearPaciente(PacienteRequestDTO dto) {
        webcliente.post()
            .uri("/pacientes")
            .bodyValue(dto)
            .retrieve()
            .onStatus(status -> status.is4xxClientError(), response -> 
                response.bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                    .flatMap(errorBody -> {
                       
                        String mensaje = "Error en los datos de la mascota";
                        
                        if (errorBody.containsKey("fechaNacimiento")) {
                            mensaje = errorBody.get("fechaNacimiento").toString();
                        } else if (errorBody.containsKey("mensaje")) {
                            mensaje = errorBody.get("mensaje").toString();
                        }
                        
                        return Mono.<Throwable>error(new RuntimeException(mensaje));
                    })
            )
            .toBodilessEntity()
            .block();
    }

    @Override
    public void eliminarPaciente(int id) {
        webcliente.delete()
                .uri("/pacientes/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public PacienteResponseDTO obtenerPorId(int id) {
        return webcliente.get()
                .uri("/pacientes/{id}", id)
                .retrieve()
                .bodyToMono(PacienteResponseDTO.class)
                .block();
    }

    @Override
    public PacienteResponseDTO buscarPorId(int idPaciente) {
        return webcliente.get()
                .uri(uriBuilder -> uriBuilder.path("/pacientes/buscarid/{idPaciente}")
                .build(idPaciente))
                .retrieve()
                .bodyToMono(PacienteResponseDTO.class)
                .block();
    }
}
