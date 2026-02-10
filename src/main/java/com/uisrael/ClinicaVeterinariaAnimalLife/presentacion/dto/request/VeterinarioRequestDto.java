package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VeterinarioRequestDto {
	
	
	
	private int idveterinario;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	
	@NotBlank(message = "La cédula es obligatoria")
	
	@NotBlank(message = "La identificación es obligatoria")
    @Size(min = 9, max = 13, message = "La identificación debe tener entre 9 y 13 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "La identificación solo debe contener letras y números")
	private String cedula;
	@NotBlank
	private String correo;
	

}
