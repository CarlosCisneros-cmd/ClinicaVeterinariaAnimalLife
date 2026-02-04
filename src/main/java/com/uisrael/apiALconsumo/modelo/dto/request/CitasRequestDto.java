package com.uisrael.apiALconsumo.modelo.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CitasRequestDto {
    private int idCita;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fecha_Hora;
    private PacienteRequestDTO fkPaciente;
    private VeterinarioRequestDto fkVeterinario;
    private List<Integer> servicios;
}