package com.uisrael.apiALconsumo.modelo.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DetallesRequestDto {
	
	private  int idDetalles;
	private  String Descripcion;
	private  String Diagnostico;
	private  String Analisis;
	private double Peso;
	private double Temperatura;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime fechaCreacion;
    private CabeceraRequestDto fkCabecera;

}
