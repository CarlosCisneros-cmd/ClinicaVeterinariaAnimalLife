package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Cabecera;

public interface ICabeceraRepositorio {

	
	Cabecera guardar(Cabecera cabecera);
	Optional<Cabecera> buscarPorId(int id);
	List<Cabecera> listarTodos();
	void eliminar(int id);
}
