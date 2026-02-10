package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.ClienteRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ClienteResponseDto;
import com.uisrael.apiALconsumo.servicio.IClienteServicio;

import reactor.core.publisher.Mono;

@Service
public class ClienteServicioImpl implements IClienteServicio {

    private final WebClient webcliente;
    
    public ClienteServicioImpl(WebClient webcliente) {
        this.webcliente = webcliente;
    }

    @Override
    public List<ClienteResponseDto> listarClientes() {
        return webcliente.get()
                .uri("/clientes")
                .retrieve()
                .bodyToFlux(ClienteResponseDto.class)
                .collectList()
                .block();
    }

    @Override
    public void crearCliente(ClienteRequestDto dto) {
        webcliente.post()
            .uri("/clientes")
            .bodyValue(dto)
            .retrieve()
            .onStatus(status -> status.is4xxClientError(), response -> 
                response.bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                    .flatMap(errorBody -> {
                        Object mensajeObj = errorBody.get("mensaje");
                        String mensaje = (mensajeObj != null) ? mensajeObj.toString() : "Error en los datos enviados";
                        return Mono.<Throwable>error(new RuntimeException(mensaje));
                    })
            )
            .toBodilessEntity()
            .block();
    }

    @Override
    public void eliminarCliente(int id) {
        webcliente.delete()
                .uri("/clientes/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public ClienteResponseDto obtenerPorId(int id) {
        return webcliente.get()
                .uri("/clientes/{id}", id)
                .retrieve()
                .bodyToMono(ClienteResponseDto.class)
                .block();
    }

    @Override
    public ClienteResponseDto buscarPorId(int idCliente) {
        return webcliente.get()
                .uri(uriBuilder -> uriBuilder.path("/clientes/buscarid/{idCliente}")
                .build(idCliente))
                .retrieve()
                .bodyToMono(ClienteResponseDto.class)
                .block();
    }

    

    @Override
    public List<ClienteResponseDto> listarClientesInactivos() {
        return webcliente.get()
                .uri("/clientes/inactivos") 
                .retrieve()
                .bodyToFlux(ClienteResponseDto.class)
                .collectList()
                .block();
    }

    @Override
    public void recuperarCliente(int id) {
        webcliente.put()
                .uri("/clientes/recuperar/{id}", id) 
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}