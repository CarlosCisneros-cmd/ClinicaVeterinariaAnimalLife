package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.ICitasRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.notificaciones.WhatsappService;

import jakarta.transaction.Transactional;

@Component
public class RecordatorioCitasJob {

    private final ICitasRepositorio citasRepositorio;
    private final WhatsappService whatsappService;

    public RecordatorioCitasJob(ICitasRepositorio citaRepositorio, WhatsappService whatsappService) {
        this.citasRepositorio = citaRepositorio;
        this.whatsappService = whatsappService;
    }

    // Cron: Segundos Minutos Horas Día Mes DíaSemana
    // "0 0 7 * * ?" significa: A las 07:00 AM todos los días
    
  @Scheduled(cron = "0 * * * * ?")
  //  @Scheduled(cron = "0 0 7 * * ?") 
    @Transactional
    public void enviarRecordatoriosDiarios() {
        System.out.println("⏰ Iniciando tarea de recordatorios...");
        
        LocalDate hoy = LocalDate.now();

        LocalDateTime inicioDia = hoy.atStartOfDay();
        LocalDateTime finDia = hoy.atTime(LocalTime.MAX);


        List<Citas> citasDeHoy = citasRepositorio.buscarPorRango(inicioDia, finDia);

        if (citasDeHoy.isEmpty()) {
            System.out.println("ℹ️ No hay citas programadas para hoy.");
            return;
        }


        for (Citas cita : citasDeHoy) {

            if (cita.getFkPaciente() != null 
                && cita.getFkPaciente().getFkCliente() != null 
                && cita.getFkPaciente().getFkCliente().getTelefono() != null) {

                String nombreCliente = cita.getFkPaciente().getFkCliente().getNombres();
                String nombreMascota = cita.getFkPaciente().getNombre();
                String horaCita = cita.getFecha_Hora().toLocalTime().toString(); // Extraemos solo la hora
                String telefono = cita.getFkPaciente().getFkCliente().getTelefono();

                String mensaje = String.format(
                    "Hola %s, le recordamos que tiene una cita para *%s* hoy a las *%s* en la Veterinaria AnimalLife. ¡Le esperamos! 🐾",
                    nombreCliente, nombreMascota, horaCita
                );

                whatsappService.enviarMensaje(telefono, mensaje);
            }
        }
    }
}