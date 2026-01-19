package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Servicio;

public interface IServicioUseCase {
	
	Servicio crear (Servicio servicio);
	Servicio obtenerPorId(int id);
	List<Servicio> listar();
	void eliminar (int id);
	

}
