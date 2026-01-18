package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Cabecera;



public interface ICabeceraUseCase {
	
	Cabecera crear(Cabecera cabecera);
	Cabecera obtenerPorId(int id);
	List<Cabecera> listar();
	void eliminar(int id);


}
