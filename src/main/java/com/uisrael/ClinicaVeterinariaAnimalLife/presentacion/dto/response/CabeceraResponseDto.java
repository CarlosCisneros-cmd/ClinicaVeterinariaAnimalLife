package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;

import java.time.LocalDateTime;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Paciente;

import lombok.Data;

@Data
public class CabeceraResponseDto {

	private  int idCabecera;
	private  String nombreCabecera;
	private  String nombreCliente;
	private  LocalDateTime fechaCreacion;
	private Paciente fkPaciente;
	
}
