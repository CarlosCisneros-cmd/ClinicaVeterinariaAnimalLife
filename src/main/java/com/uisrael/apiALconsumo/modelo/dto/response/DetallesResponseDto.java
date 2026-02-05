package com.uisrael.apiALconsumo.modelo.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DetallesResponseDto {
	
	private  int idDetalles;
	private  String Descripcion;
	private  String Diagnostico;
	private  String Analisis;
	private double Peso;
	private double Temperatura;
	private LocalDateTime fechaCreacion;

}
