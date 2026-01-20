package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")

public class ClientesJpa implements Serializable{

	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idCliente;
	 private String nombres;
	 private String apellidos;
	 private String telefono;
	 private String correo;
	 private String cedula;
	 private String direccion;
	
	
	 
	 

}
