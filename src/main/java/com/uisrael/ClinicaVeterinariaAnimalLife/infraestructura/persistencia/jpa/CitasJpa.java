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
@Table(name = "Citas")
public class CitasJpa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;

   
    @ManyToOne
    @JoinColumn(name = "id_paciente") 
    private PacienteJpa fkPaciente; 

    private LocalDateTime fecha_Hora;
    
    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private VeterinarioJpa fkVeterinario;
}