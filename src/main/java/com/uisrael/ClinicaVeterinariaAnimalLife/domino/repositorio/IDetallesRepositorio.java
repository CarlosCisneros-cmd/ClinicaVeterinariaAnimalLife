package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Detalles;


public interface IDetallesRepositorio {

	Detalles guardar(Detalles detalles);
	Optional<Detalles> buscarPorId(int id);
	List<Detalles> listarTodos();
	void eliminar(int id);
	
	List<Detalles> buscarDetallePorClienteyPaciente(String nombreCliente, String nombrePaciente);
}
