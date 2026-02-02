package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cabecera implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private final int idCabecera;
	private final String nombreCabecera;
	private final String nombreCliente;
	private final LocalDateTime fechaCreacion;
	private final Paciente fkPaciente;
	
	public Cabecera(int idCabecera, String nombreCabecera, String nombreCliente, LocalDateTime fechaCreacion,
			Paciente fkPaciente) {
		super();
		this.idCabecera = idCabecera;
		this.nombreCabecera = nombreCabecera;
		this.nombreCliente = nombreCliente;
		this.fechaCreacion = fechaCreacion;
		this.fkPaciente = fkPaciente;
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

	public Paciente getFkPaciente() {
		return fkPaciente;
	}

	@Override
	public String toString() {
		return "Cabecera [idCabecera=" + idCabecera + ", nombreCabecera=" + nombreCabecera + ", nombreCliente="
				+ nombreCliente + ", fechaCreacion=" + fechaCreacion + ", fkPaciente=" + fkPaciente + "]";
	}
	
	
	
	

}
