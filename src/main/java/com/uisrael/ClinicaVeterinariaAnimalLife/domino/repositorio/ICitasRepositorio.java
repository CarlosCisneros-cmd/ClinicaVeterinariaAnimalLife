package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;


public interface ICitasRepositorio {

	Citas guardar(Citas citas);
	Optional<Citas> buscarPorId(int id);
	List<Citas> listarTodos();
	void eliminar(int id);
}
