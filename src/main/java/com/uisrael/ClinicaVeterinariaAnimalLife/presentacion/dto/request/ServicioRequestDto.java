package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServicioRequestDto {
	
	private int idservicio;
	@NotBlank
	private String nombre_ser;
	
	private CitasRequestDto fkCita;

}
