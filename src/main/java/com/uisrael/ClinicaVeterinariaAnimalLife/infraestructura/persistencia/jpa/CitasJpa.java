package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable; 
import jakarta.persistence.ManyToMany; 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Citas")
@SQLDelete(sql = "UPDATE citas SET estado = false WHERE id_cita = ?")
@SQLRestriction("estado = true")
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

    @Column(nullable = false)
    private boolean estado = true;
    
    @ManyToMany
    @JoinTable(
      name = "cita_servicio", 
      joinColumns = @JoinColumn(name = "id_cita"),
      inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private List<ServicioJpa> servicios; 
}