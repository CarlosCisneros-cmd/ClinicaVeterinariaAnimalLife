package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VeterinarioRequestDto {
	
	
	
	private int idveterinario;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String cedula;
	@NotBlank
	private String correo;
	

}
