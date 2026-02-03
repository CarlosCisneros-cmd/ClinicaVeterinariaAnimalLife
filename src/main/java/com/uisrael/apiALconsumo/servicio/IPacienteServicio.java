package com.uisrael.apiALconsumo.servicio;

import java.util.List;

import com.uisrael.apiALconsumo.modelo.dto.request.PacienteRequestDTO;
import com.uisrael.apiALconsumo.modelo.dto.response.PacienteResponseDTO;

public interface IPacienteServicio {

	public List<PacienteResponseDTO>Listarpaciente();
	public void crearPaciente(PacienteRequestDTO dto);
	public void eliminarPaciente(int id);
}
