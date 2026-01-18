package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Citas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final int idCita;
	private final LocalDateTime fecha_Hora;
	private final Paciente fkPaciente; 
	private final Veterinario fkVeterinario;

	public Citas(int idCita, LocalDateTime fecha_Hora, Paciente fkPaciente, Veterinario fkVeterinario) {
		super();
		this.idCita = idCita;
		this.fecha_Hora = fecha_Hora;
		this.fkPaciente = fkPaciente;
		this.fkVeterinario = fkVeterinario;
	}

	public int getIdCita() {
		return idCita;
	}

	public LocalDateTime getFecha_Hora() {
		return fecha_Hora;
	}

	public Paciente getFkPaciente() {
		return fkPaciente;
	}

	public Veterinario getFkVeterinario() {
		return fkVeterinario;
	}

	@Override
	public String toString() {
		return "Citas [idCita=" + idCita + ", fecha_Hora=" + fecha_Hora + "]";
	}
}
