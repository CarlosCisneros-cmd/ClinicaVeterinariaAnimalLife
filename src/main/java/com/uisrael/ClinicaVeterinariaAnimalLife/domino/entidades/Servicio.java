package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;

public class Servicio implements Serializable {
	
	/**
	 * 
	 */
	private final static long serialVersionUID = 1L;
	
		private final int idservicio;
		private final String nombre_ser;
		private Citas fkCita;
		
		
		public Servicio(int idservicio, String nombre_ser, Citas fkCita) {
			super();
			this.idservicio = idservicio;
			this.nombre_ser = nombre_ser;
			this.fkCita = fkCita;
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


		public int getIdservicio() {
			return idservicio;
		}


		public String getNombre_ser() {
			return nombre_ser;
		}


		@Override
		public String toString() {
			return "Servicio [idservicio=" + idservicio + ", nombre_ser=" + nombre_ser + ", fkCita=" + fkCita + "]";
		}
		
		
		
		
		
	

}
