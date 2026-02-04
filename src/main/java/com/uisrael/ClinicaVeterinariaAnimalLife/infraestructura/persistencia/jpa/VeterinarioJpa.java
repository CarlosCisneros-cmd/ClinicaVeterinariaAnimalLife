package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="veterinario")
@SQLDelete(sql = "UPDATE veterinario SET estado = false WHERE idveterinario = ?")
@SQLRestriction("estado = true")
public class VeterinarioJpa implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idveterinario;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	@Column(nullable = false) 
	private boolean estado = true;
	

}
