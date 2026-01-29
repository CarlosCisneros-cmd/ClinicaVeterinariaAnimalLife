package com.uisrael.apiALconsumo.modelo.dto.request;

import lombok.Data;

@Data
public class VeterinarioRequestDto {
	
	private int idveterinario;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	

}
