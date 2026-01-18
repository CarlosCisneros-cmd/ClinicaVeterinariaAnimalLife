package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.ICitaUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.ICitasRepositorio;

public class CitasUseCaseImpl implements ICitaUseCase{
	
	private final ICitasRepositorio repositorio;
	

	public CitasUseCaseImpl(ICitasRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}
	

	@Override
	public Citas crear(Citas citas) {
		return repositorio.guardar(citas);
	}

	@Override
	public Citas obtenerPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() ->new RuntimeException("Cita no encontrada"));
	}

	@Override
	public List<Citas> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}

}
