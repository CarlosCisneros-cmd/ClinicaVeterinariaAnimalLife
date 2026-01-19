package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Paciente;

public interface IPacienteRepositorio {

	Paciente guardar(Paciente paciente);
	Optional<Paciente> bucarPorId(int id);
	List<Paciente> listarTodos();
	void eliminar(int id);
	
	List<Paciente> buscarPorEspecie(String especie);
}
