package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private double Peso;
	@NotNull
	private double Temperatura;
	@NotNull
	private LocalDateTime fechaCreacion;
	
	private CabeceraRequestDto fkCabecera;
	
	private CitasRequestDto fkCita;

}