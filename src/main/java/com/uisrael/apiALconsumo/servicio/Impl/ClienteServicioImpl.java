package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.apiALconsumo.modelo.dto.request.ClienteRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ClienteResponseDto;
import com.uisrael.apiALconsumo.servicio.IClienteServicio;

@Service
public class ClienteServicioImpl implements IClienteServicio {

    private final WebClient webcliente;
    
    public ClienteServicioImpl(WebClient webcliente) {
        this.webcliente = webcliente;
    }

    @Override
    public List<ClienteResponseDto> listarClientes() {
        return webcliente.get().uri("/clientes").retrieve().bodyToFlux(ClienteResponseDto.class).collectList().block();
    }

    @Override
    public void crearCliente(ClienteRequestDto dto) {
        webcliente.post().uri("/clientes").bodyValue(dto).retrieve().toBodilessEntity().block();
    }

    @Override
    public void eliminarCliente(int id) {
        webcliente.delete().uri("/clientes/{id}", id) .retrieve().toBodilessEntity().block();
    }
    @Override
    public ClienteResponseDto obtenerPorId(int id) {
        return webcliente.get().uri("/clientes/{id}", id).retrieve().bodyToMono(ClienteResponseDto.class).block();
    }
}