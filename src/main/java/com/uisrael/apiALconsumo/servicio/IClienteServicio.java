package com.uisrael.apiALconsumo.servicio;

import java.util.List;
import com.uisrael.apiALconsumo.modelo.dto.request.ClienteRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ClienteResponseDto;

public interface IClienteServicio {
    public List<ClienteResponseDto> listarClientes();
    public void crearCliente(ClienteRequestDto dto);
    public void eliminarCliente(int id);
    ClienteResponseDto obtenerPorId(int id);
    ClienteResponseDto buscarPorId(int idCliente);
    List<ClienteResponseDto> listarClientesInactivos();
    void recuperarCliente(int id);
}
