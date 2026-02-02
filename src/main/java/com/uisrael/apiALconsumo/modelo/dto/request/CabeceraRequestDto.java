package com.uisrael.apiALconsumo.modelo.dto.request;

import java.time.LocalDateTime;

import com.uisrael.apiALconsumo.modelo.dto.response.PacienteResponseDTO;

import lombok.Data;


@Data
public class CabeceraRequestDto {
	
	private  int idCabecera;
	private  String nombreCabecera;
	private  String nombreCliente;
	private  LocalDateTime fechaCreacion;
	private  PacienteResponseDTO fkPaciente;
}
