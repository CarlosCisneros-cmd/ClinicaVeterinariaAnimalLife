package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;

public class Veterinario implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID=1L; 
	private final int idveterinario;
	private final String nombre;
	private final String apellido;
	private final String cedula;
	private final String correo;
	
	public Veterinario(int idveterinario, String nombre, String apellido, String cedula, String correo) {
		
		this.idveterinario = idveterinario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.correo = correo;
	}

	public int getIdveterinario() {
		return idveterinario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public String getCorreo() {
		return correo;
	}

	@Override
	public String toString() {
		return "Veterinario [idveterinario=" + idveterinario + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", cedula=" + cedula + ", correo=" + correo + "]";
	}
	

}
