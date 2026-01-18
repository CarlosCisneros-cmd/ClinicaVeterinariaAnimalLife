package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;


import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IVeterinarioUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IVeterinarioRepositorio;


public class VeterinarioUseCaseImpl implements IVeterinarioUseCase {
	
	private final IVeterinarioRepositorio repositorio;

	
	public VeterinarioUseCaseImpl(IVeterinarioRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Veterinario crear(Veterinario veterinario) {
		// TODO Auto-generated method stub
		return repositorio.guardar(veterinario);
	}

	@Override
	public Veterinario obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(()->
				new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Veterinario> listar() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}
	
	

}
