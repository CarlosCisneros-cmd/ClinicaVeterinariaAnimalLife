package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class DetallesResponseDto {

	private  int idDetalles;
	private  String Descripcion;
	private  String Diagnostico;
	private  String Analisis;
	private LocalDateTime fechaCreacion;
	private CabeceraResponseDto fkCabecera;
	
}
