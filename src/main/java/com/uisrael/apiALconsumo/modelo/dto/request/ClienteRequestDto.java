package com.uisrael.apiALconsumo.modelo.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDto {
	
	private int idCliente;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String correo;
	private String cedula;
	private String direccion;

}
