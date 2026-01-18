package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CitasRequestDto {
	@NotBlank
	private  int idCita;
	@NotBlank
	private  int idPaciente;
	@NotBlank
	private  int idVeterinario;
	@NotBlank
	private  LocalDateTime fecha_Hora;
	
	private VeterinarioRequestDto fkVeterinario;
	

}
