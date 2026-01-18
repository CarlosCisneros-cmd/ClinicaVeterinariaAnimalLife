package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CitasRequestDto {
	private int idCita;

    @NotBlank
    private PacienteRequestDTO fkPaciente;

    @NotBlank
    private VeterinarioRequestDto fkVeterinario;

    @NotBlank
    private LocalDateTime fecha_Hora;
	

}
