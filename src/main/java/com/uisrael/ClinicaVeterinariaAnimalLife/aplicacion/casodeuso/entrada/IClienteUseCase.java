package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Clientes;

public interface IClienteUseCase {
	
	Clientes crear(Clientes cliente);
	Clientes obtenerPorId(int id);
	List<Clientes> listar();
	void eliminar(int id);
	
	List<Clientes> buscarPorNombresyCorreo (String nombres, String correo);

}
