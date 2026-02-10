package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CitasRequestDto {
	private int idCita;

	@NotNull
    private PacienteRequestDTO fkPaciente;

    @NotNull
    private VeterinarioRequestDto fkVeterinario;

    @NotNull(message = "La fecha y hora son obligatorias")
    
    @FutureOrPresent(message = "No se pueden agendar citas en fechas o horas pasadas")
    private LocalDateTime fecha_Hora;
    
    private List<Integer> servicios;
	

}
