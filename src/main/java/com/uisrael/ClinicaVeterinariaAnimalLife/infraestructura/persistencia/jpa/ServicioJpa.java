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
@Table(name ="servicio")
@SQLDelete(sql = "UPDATE servicio SET estado = false WHERE idservicio = ?")
@SQLRestriction("estado = true")
public class ServicioJpa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idservicio;
	private String nombre_ser;
	@Column(nullable = false) 
    private boolean estado = true;
	

	
	

}
