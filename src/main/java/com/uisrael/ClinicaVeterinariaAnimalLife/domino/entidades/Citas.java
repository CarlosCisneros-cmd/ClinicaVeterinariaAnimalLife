package com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List; 

public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final int idCita;
    private final LocalDateTime fecha_Hora;
    private final Paciente fkPaciente; 
    private final Veterinario fkVeterinario;
    private final boolean estado; 
    private final List<Servicio> servicios; 

    
    public Citas(int idCita, LocalDateTime fecha_Hora, Paciente fkPaciente, 
                 Veterinario fkVeterinario, boolean estado, List<Servicio> servicios) {
        super();
        this.idCita = idCita;
        this.fecha_Hora = fecha_Hora;
        this.fkPaciente = fkPaciente;
        this.fkVeterinario = fkVeterinario;
        this.estado = estado;
        this.servicios = servicios;
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

    public boolean isEstado() {
        return estado;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    @Override
    public String toString() {
        return "Citas [idCita=" + idCita + ", fecha_Hora=" + fecha_Hora + ", servicios=" + servicios + "]";
    }
}
