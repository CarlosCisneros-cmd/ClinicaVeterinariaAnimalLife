package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;

public interface IVeterinarioRepositorio {
	
	Veterinario guardar(Veterinario veterinario);
	Optional<Veterinario> buscarPorId(int id);
	List<Veterinario> listarTodos();
	void eliminar(int id);

}
