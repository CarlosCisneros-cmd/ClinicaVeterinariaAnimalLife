package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Detalles")
public class DetallesJpa implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idDetalles;
	private  String Descripcion;
	private  String Diagnostico;
	private  String Analisis;
	private LocalDateTime fechaCreacion;
	
	@ManyToOne
	@JoinColumn(name = "id_Cabecera")
	private CabeceraJpa fkCabecera;

}


