package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cabecera implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private final int idCabecera;
	private final String nombreCabecera;
	private final String nombreCliente;
	private final LocalDateTime fechaCreacion;
	
	
	public Cabecera(int idCabecera, String nombreCabecera, String nombreCliente, LocalDateTime fechaCreacion) {;
		this.idCabecera = idCabecera;
		this.nombreCabecera = nombreCabecera;
		this.nombreCliente = nombreCliente;
		this.fechaCreacion = fechaCreacion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getIdCabecera() {
		return idCabecera;
	}


	public String getNombreCabecera() {
		return nombreCabecera;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	@Override
	public String toString() {
		return "Cabecera [idCabecera=" + idCabecera + ", nombreCabecera=" + nombreCabecera + ", nombreCliente="
				+ nombreCliente + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	
	

}
