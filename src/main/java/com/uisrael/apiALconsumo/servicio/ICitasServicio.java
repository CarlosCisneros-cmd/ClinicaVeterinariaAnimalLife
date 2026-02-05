package com.uisrael.apiALconsumo.servicio;

import java.util.List;
import com.uisrael.apiALconsumo.modelo.dto.request.CitasRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.CitasResponseDto;

public interface ICitasServicio {
    List<CitasResponseDto> listarCitas();
    void crearCita(CitasRequestDto cita);
    void eliminarCita(int id);
    CitasResponseDto buscarPorId(int idCita);
}
