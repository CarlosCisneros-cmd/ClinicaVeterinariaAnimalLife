package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Detalles implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private final int idDetalles;
	private final String Descripcion;
	private final String Diagnostico;
	private final String Analisis;
	private final LocalDateTime fechaCreacion;
	private Cabecera fkCabecera;
	
	
	public Detalles(int idDetalles, String descripcion, String diagnostico, String analisis,
			LocalDateTime fechaCreacion, Cabecera fkCabecera) {
		super();
		this.idDetalles = idDetalles;
		Descripcion = descripcion;
		Diagnostico = diagnostico;
		Analisis = analisis;
		this.fechaCreacion = fechaCreacion;
		this.fkCabecera = fkCabecera;
	}


	public Cabecera getFkCabecera() {
		return fkCabecera;
	}


	public void setFkCabecera(Cabecera fkCabecera) {
		this.fkCabecera = fkCabecera;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getIdDetalles() {
		return idDetalles;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public String getDiagnostico() {
		return Diagnostico;
	}


	public String getAnalisis() {
		return Analisis;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
}
	
