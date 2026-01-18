package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;
import java.util.List;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Detalles;

public interface IDetallesUseCase {

	Detalles crear(Detalles detalles);
	Detalles obtenerPorId(int id);
	List<Detalles> listar();
	void eliminar(int id);
	
}
