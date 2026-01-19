package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDto {
	
	
	private int idCliente;
	@NotBlank
	private String nombres;
	@NotBlank
	private String apellidos;
	@NotBlank
	private String telefono;
	@NotBlank
	private String correo;
	@NotBlank
	private String cedula;
	@NotBlank
	private String direccion;
	
}
