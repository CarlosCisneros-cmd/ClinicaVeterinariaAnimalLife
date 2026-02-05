package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Detalles implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private final int idDetalles;
	private final String Descripcion;
	private final String Diagnostico;
	private final String Analisis;
	private final double Peso;
	private final double Temperatura;
	private final LocalDateTime fechaCreacion;
	private Cabecera fkCabecera;
	private Citas fkCita;
	
	
	public Detalles(int idDetalles, String descripcion, String diagnostico, String analisis, double peso,
			double temperatura, LocalDateTime fechaCreacion, Cabecera fkCabecera, Citas fkCita) {
		this.idDetalles = idDetalles;
		Descripcion = descripcion;
		Diagnostico = diagnostico;
		Analisis = analisis;
		Peso = peso;
		Temperatura = temperatura;
		this.fechaCreacion = fechaCreacion;
		this.fkCabecera = fkCabecera;
		this.fkCita = fkCita;
	}


	public Cabecera getFkCabecera() {
		return fkCabecera;
	}


	public void setFkCabecera(Cabecera fkCabecera) {
		this.fkCabecera = fkCabecera;
	}


	public Citas getFkCita() {
		return fkCita;
	}


	public void setFkCita(Citas fkCita) {
		this.fkCita = fkCita;
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


	public double getPeso() {
		return Peso;
	}


	public double getTemperatura() {
		return Temperatura;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	@Override
	public String toString() {
		return "Detalles [idDetalles=" + idDetalles + ", Descripcion=" + Descripcion + ", Diagnostico=" + Diagnostico
				+ ", Analisis=" + Analisis + ", Peso=" + Peso + ", Temperatura=" + Temperatura + ", fechaCreacion="
				+ fechaCreacion + ", fkCabecera=" + fkCabecera + ", fkCita=" + fkCita + "]";
	}


	public void setFechaCreacion(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}


	public void setIdDetalles(int id) {
		
		
	}
	
	
	
	
}
	
	