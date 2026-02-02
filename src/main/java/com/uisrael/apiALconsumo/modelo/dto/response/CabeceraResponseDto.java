package com.uisrael.apiALconsumo.modelo.dto.response;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class CabeceraResponseDto {

	private  int idCabecera;
	private  String nombreCabecera;
	private  String nombreCliente;
	private  LocalDateTime fechaCreacion;
	private  PacienteResponseDTO fkPaciente;
}
