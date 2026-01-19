package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;



import lombok.Data;
@Data
public class PacienteResponseDTO {
	
	
	private int idPaciente;
	private String raza;
	private String sexo;
	private String especie;
	private ClienteResponseDto fkCliente;
	

}


