package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CitasRequestDto {
	private int idCita;

	@NotNull
    private PacienteRequestDTO fkPaciente;

    @NotNull
    private VeterinarioRequestDto fkVeterinario;

    @NotNull
    private LocalDateTime fecha_Hora;
    
    private List<Integer> servicios;
	

}
