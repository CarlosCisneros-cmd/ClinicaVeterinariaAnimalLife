package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Paciente;

public interface IPacienteUseCase {
	
	Paciente crear(Paciente paciente);
	Paciente obtenerPoriD(int id);
	List<Paciente> listar();
	void eliminar(int id);

	
	List<Paciente> buscarPorEspecie(String especie);
	List<Paciente> buscarPacientesPorNombreVeterinario(String nombreVeterinario);
	List<Paciente> buscarPacientesPorNombreCliente(String nombreCliente);
}
