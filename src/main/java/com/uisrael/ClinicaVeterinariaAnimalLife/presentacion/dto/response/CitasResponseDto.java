package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class CitasResponseDto {
	
	private  int idCita;
	private  int idPaciente;
	private  int idVeterinario;
	private  LocalDateTime fecha_Hora;
	private VeterinarioResponseDto fkVeterinario;

}

