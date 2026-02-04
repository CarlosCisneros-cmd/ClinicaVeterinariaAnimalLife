package com.uisrael.apiALconsumo.modelo.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class CitasResponseDto {
    private int idCita;
    private LocalDateTime fecha_Hora;
    private PacienteResponseDTO fkPaciente;
    private VeterinarioResponseDto fkVeterinario;
    private boolean estado;
    private List<ServicioResponseDto> servicios;
}