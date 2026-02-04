package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;

public class Servicio implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	private final int idservicio;
	private final String nombre_ser;
	private final boolean estado; 

	
	public Servicio(int idservicio, String nombre_ser, boolean estado) {
		super();
		this.idservicio = idservicio;
		this.nombre_ser = nombre_ser;
		this.estado = estado;
	}

	public int getIdservicio() {
		return idservicio;
	}

	public String getNombre_ser() {
		return nombre_ser;
	}

	public boolean isEstado() {
		return estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Servicio [idservicio=" + idservicio + ", nombre_ser=" + nombre_ser + ", estado=" + estado + "]";
	}
}