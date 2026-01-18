package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;

public interface IVeterinarioUseCase {
	
	Veterinario crear (Veterinario veterinario);
	Veterinario obtenerPorId(int id);
	List<Veterinario> listar();
	void eliminar(int id);
	
	

}
