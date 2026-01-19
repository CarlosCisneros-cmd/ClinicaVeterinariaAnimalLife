package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Servicio;


public interface IServicioRepositorio {
	
	Servicio guardar (Servicio servicio);
	Optional<Servicio> buscarPorId (int id);
	List<Servicio> listarTodos();
	void eliminar (int id);
	
	

}
