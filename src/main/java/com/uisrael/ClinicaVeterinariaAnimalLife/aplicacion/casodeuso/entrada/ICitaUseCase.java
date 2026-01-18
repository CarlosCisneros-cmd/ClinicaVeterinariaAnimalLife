package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;


public interface ICitaUseCase {
	
	Citas crear(Citas citas);
	Citas obtenerPorId(int id);
	List<Citas> listar();
	void eliminar(int id);

}

