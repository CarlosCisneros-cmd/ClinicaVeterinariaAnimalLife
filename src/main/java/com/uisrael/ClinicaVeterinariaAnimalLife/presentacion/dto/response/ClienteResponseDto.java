package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;

import lombok.Data;

@Data
public class ClienteResponseDto {

	private int idCliente;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String correo;
	private String cedula;
	private String direccion;
	private boolean estado;
	
	

	}
	
	