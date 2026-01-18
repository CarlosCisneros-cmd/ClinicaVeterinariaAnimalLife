package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServicioRequestDto {
	
	@NotBlank
	private String nombre_ser;

}
