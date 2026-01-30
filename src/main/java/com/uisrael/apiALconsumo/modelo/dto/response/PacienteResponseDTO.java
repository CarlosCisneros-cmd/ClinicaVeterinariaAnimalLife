package com.uisrael.apiALconsumo.modelo.dto.response;


import lombok.Data;

@Data
public class PacienteResponseDTO {
	private int idPaciente;
	private String raza;
	private String sexo;
	private String especie;
	private ClienteResponseDto fkCliente;
}
