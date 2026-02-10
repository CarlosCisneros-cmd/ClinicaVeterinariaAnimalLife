package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteRequestDto {
	
	private int idCliente;

	@NotBlank(message = "Los nombres son obligatorios")
	private String nombres;

	@NotBlank(message = "Los apellidos son obligatorios")
	private String apellidos;

	
	@NotBlank(message = "El teléfono es obligatorio")
	@Pattern(regexp = "^09\\d{8}$", message = "El teléfono debe empezar con 09 y tener 10 dígitos numéricos")
	private String telefono;

	
	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "Debe ingresar un formato de correo válido")
	private String correo;

	
	@NotBlank(message = "La identificación es obligatoria")
	
	@Size(min = 9, max = 13, message = "La identificación (cédula o pasaporte) debe tener entre 9 y 13 caracteres")
	
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "La identificación solo debe contener letras y números")
	private String cedula;

	@NotBlank(message = "La dirección es obligatoria")
	private String direccion;
}
