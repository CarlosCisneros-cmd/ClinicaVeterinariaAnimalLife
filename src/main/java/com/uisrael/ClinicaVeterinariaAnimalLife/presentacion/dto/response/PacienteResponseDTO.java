package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response;



import java.time.LocalDate;

import lombok.Data;
@Data
public class PacienteResponseDTO {
	
	
	private int idPaciente;
	private String nombre;
	private String raza;
	private String sexo;
	private String especie;
    private String color;
    private LocalDate fechaNacimiento;
    private boolean estado;
	private ClienteResponseDto fkCliente;
	

}


