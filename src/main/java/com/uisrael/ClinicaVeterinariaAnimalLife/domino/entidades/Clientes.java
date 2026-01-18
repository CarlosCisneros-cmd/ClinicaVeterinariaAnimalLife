package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;

public class Clientes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int idCliente;
	private final String nombres;
	private final String apellidos;
	private final String telefono;
	private final String correo;
	private final String cedula;
	private final String direccion;
		
	

	public Clientes(int idCliente, String nombres, String apellidos, String telefono, String correo, String cedula,
			String direccion) {
		
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.cedula = cedula;
		this.direccion = direccion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public String getCedula() {
		return cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	
	
	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", correo=" + correo + ", cedula=" + cedula + ", direccion=" + direccion + "]";
	}
	



	
	
}
