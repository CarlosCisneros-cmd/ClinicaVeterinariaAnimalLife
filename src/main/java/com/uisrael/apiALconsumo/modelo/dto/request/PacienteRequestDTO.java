package com.uisrael.apiALconsumo.modelo.dto.request;


import lombok.Data;

@Data
public class PacienteRequestDTO {
	private int idPaciente;
	private String nombre;
	private String raza;
	private String sexo;
	private String especie;
	private ClienteRequestDto fkCliente;
	
}
