package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;

import lombok.Data;

@Data
public class VeterinarioResponseDto {
	
	private int idveterinario;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	private boolean estado;
	
	
	

}
