package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CabeceraRequestDto {
	
	@NotBlank
	private  int idCabecera;
	@NotBlank
	private  String nombreCabecera;
	@NotBlank
	private  String nombreCliente;
	@NotBlank
	private  LocalDateTime fechaCreacion;

}
