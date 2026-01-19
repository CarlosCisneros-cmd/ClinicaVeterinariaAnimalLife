package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;


public class Paciente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int idPaciente;
	private final String raza;
	private final String sexo;
	private final String especie;
	private Clientes fkCliente;
	
	public Paciente(int idPaciente, String raza, String sexo, String especie, Clientes fkCliente) {
		super();
		this.idPaciente = idPaciente;
		this.raza = raza;
		this.sexo = sexo;
		this.especie = especie;
		this.fkCliente = fkCliente;
	}
	public int getIdPaciente() {
		return idPaciente;
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
	
	public Clientes getFkCliente() {
		return fkCliente;
	}
	public void setFkCliente(Clientes fkCliente) {
		this.fkCliente = fkCliente;
	}
	
	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", raza=" + raza + ", sexo=" + sexo + ", especie=" + especie
				+ "]";
	}
}
