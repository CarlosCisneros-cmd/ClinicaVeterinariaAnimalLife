package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Clientes;

public interface IClientesRepositorio {
	
	Clientes guardar(Clientes clientes);
	Optional<Clientes> buscarPorId(int id);
	List<Clientes> listarTodos();
	void eliminar(int id);

}
