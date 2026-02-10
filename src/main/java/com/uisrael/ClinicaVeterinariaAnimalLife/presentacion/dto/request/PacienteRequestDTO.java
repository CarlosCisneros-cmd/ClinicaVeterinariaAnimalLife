package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
    
    
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @PastOrPresent(message = "La fecha de nacimiento no puede ser una fecha futura")
     private LocalDate fechaNacimiento;
	
	private ClienteRequestDto fkCliente;
	
}
