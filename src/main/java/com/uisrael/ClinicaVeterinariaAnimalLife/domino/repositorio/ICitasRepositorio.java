package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;


public interface ICitasRepositorio {

	Citas guardar(Citas citas);
	Optional<Citas> buscarPorId(int id);
	List<Citas> listarTodos();
	void eliminar(int id);
	
	List<Citas> buscarPorRango(LocalDateTime inicio, LocalDateTime fin);
	List<Citas> buscarCitasPorVeterinarioyFecha(String nombre, LocalDateTime fecha_Hora);
}
