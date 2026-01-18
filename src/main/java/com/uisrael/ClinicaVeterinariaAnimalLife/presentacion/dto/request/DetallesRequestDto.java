package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetallesRequestDto {
	
	@NotBlank
	private  int idDetalles;
	@NotBlank
	private  String Descripcion;
	@NotBlank
	private  String Diagnostico;
	@NotBlank
	private  String Analisis;
	@NotBlank
	private LocalDateTime fechaCreacion;
	
	private CabeceraRequestDto fkCabecera;

}