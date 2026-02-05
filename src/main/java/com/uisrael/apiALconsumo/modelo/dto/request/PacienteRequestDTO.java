package com.uisrael.apiALconsumo.modelo.dto.request;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PacienteRequestDTO {
	private int idPaciente;
	private String nombre;
	private String raza;
	private String sexo;
	private String especie;
	private String color;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
	private ClienteRequestDto fkCliente;
	
}
