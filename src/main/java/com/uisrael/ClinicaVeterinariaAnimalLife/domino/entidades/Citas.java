package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Citas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int idCita;
	private final int idPaciente;
	private final LocalDateTime fecha_Hora;
	private Veterinario fkVeterinario;
	
	


	public Citas(int idCita, int idPaciente, int idVeterinario, LocalDateTime fecha_Hora, Veterinario fkVeterinario) {
		super();
		this.idCita = idCita;
		this.idPaciente = idPaciente;
		this.fecha_Hora = fecha_Hora;
		this.fkVeterinario = fkVeterinario;
	}



	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdCita() {
		return idCita;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public LocalDateTime getFecha_Hora() {
		return fecha_Hora;
	}
	public Veterinario getFkVeterinario() {
		return fkVeterinario;
	}

	public void setFkVeterinario(Veterinario fkVeterinario) {
		this.fkVeterinario = fkVeterinario;
	}

	@Override
	public String toString() {
		return "Citas [idCita=" + idCita + ", idPaciente=" + idPaciente + ", idVeterinario=" + ", fecha_Hora=" + fecha_Hora + "]";
	
	}
}
