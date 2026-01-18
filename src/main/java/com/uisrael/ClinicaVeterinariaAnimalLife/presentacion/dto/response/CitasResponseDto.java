package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class CitasResponseDto {
	
	private int idCita;
	private PacienteResponseDTO fkPaciente;    
    private VeterinarioResponseDto fkVeterinario; 
    private LocalDateTime fecha_Hora; 
}

