package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;

import lombok.Data;

@Data
public class ServicioResponseDto {
	
	private int idservicio;
	private String nombre_ser;
	
	private CitasResponseDto fkCita;

	

}
