package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacienteRequestDTO {

	
	private int idPaciente;
	@NotBlank
	private String nombre;
	@NotBlank
	private String raza;
	@NotBlank
	private String sexo;
	@NotBlank
	private String especie;
	
	private ClienteRequestDto fkCliente;
	
}
