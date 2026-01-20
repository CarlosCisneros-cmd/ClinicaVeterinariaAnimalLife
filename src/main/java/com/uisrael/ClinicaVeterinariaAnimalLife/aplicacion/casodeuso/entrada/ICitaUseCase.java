package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;

import java.time.LocalDateTime;
import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;


public interface ICitaUseCase {
	
	Citas crear(Citas citas);
	Citas obtenerPorId(int id);
	List<Citas> listar();
	void eliminar(int id);

	List<Citas> buscarCitasPorVeterinarioyFecha(String nombre, LocalDateTime fecha_Hora);
	List<Citas> buscarPorRango(LocalDateTime inicio, LocalDateTime fin);
	
	
}

