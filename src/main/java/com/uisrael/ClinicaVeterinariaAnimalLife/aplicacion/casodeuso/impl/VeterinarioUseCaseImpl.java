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
		
		if (repositorio.existePorCedula(veterinario.getCedula())) {
			throw new RuntimeException("No se puede registrar: La cédula " + veterinario.getCedula() + " ya existe.");
		}
		
		
		if (repositorio.existePorCorreo(veterinario.getCorreo())) {
			throw new RuntimeException("No se puede registrar: El correo " + veterinario.getCorreo() + " ya está en uso.");
		}

		
		return repositorio.guardar(veterinario);
	}

	@Override
	public Veterinario obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
	}

	@Override
	public List<Veterinario> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}
	
	@Override
	public List<Veterinario> buscarPorApellido(String apellido) {
		return repositorio.buscarPorApellido(apellido);
	}
}
