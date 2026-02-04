package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDate;

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
	
    private String color;
    
    private LocalDate fechaNacimiento;
	
	private ClienteRequestDto fkCliente;
	
}
