package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDate;


public class Paciente implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private final int idPaciente;
	private final String nombre;
	private final String raza;
	private final String sexo;
	private final String especie;
	private final String color; 
    private final LocalDate fechaNacimiento; 
    private final boolean estado; 
	private Clientes fkCliente;
	
	public Paciente(int idPaciente, String nombre, String raza, String sexo, String especie, String color,
			LocalDate fechaNacimiento, boolean estado, Clientes fkCliente) {
		super();
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.raza = raza;
		this.sexo = sexo;
		this.especie = especie;
		this.color = color;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.fkCliente = fkCliente;
	}

	public Clientes getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Clientes fkCliente) {
		this.fkCliente = fkCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRaza() {
		return raza;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEspecie() {
		return especie;
	}

	public String getColor() {
		return color;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean isEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombre=" + nombre + ", raza=" + raza + ", sexo=" + sexo
				+ ", especie=" + especie + ", color=" + color + ", fechaNacimiento=" + fechaNacimiento + ", estado="
				+ estado + ", fkCliente=" + fkCliente + "]";
	}
	
	
	
	
	
}
