package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
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
@Table(name = "paciente")
@SQLDelete(sql = "UPDATE paciente SET estado = false WHERE id_paciente = ?")
@SQLRestriction("estado = true")
public class PacienteJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaciente;
	private String nombre;
	private String raza;
	private String sexo;
	private String especie;
	private String color;
    private LocalDate fechaNacimiento;
    @Column(nullable = false)
    private boolean estado = true;
	
	
	@ManyToOne
	@JoinColumn(name = "id_Cliente")
	private ClientesJpa fkCliente;
	
	 
	 
	
}
