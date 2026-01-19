package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IServicioUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Servicio;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IServicioRepositorio;

public class ServicioUseCaseImpl implements IServicioUseCase{
	
	private final IServicioRepositorio repositorio;

	public ServicioUseCaseImpl(IServicioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Servicio crear(Servicio servicio) {
		// TODO Auto-generated method stub
		return repositorio.guardar(servicio);
	}

	@Override
	public Servicio obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() ->
				new RuntimeException("Servicio no encontrado"));
	}

	@Override
	public List<Servicio> listar() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}
	
	

}
