package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.ICabeceraUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Cabecera;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.ICabeceraRepositorio;

public class CabeceraUseCaseImpl implements ICabeceraUseCase{
	
	private final ICabeceraRepositorio repositorio;
	

	public CabeceraUseCaseImpl(ICabeceraRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	
	@Override
	public Cabecera crear(Cabecera cabecera) {
		return repositorio.guardar(cabecera);
	}

	@Override
	public Cabecera obtenerPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() 
				->new RuntimeException("Cabecera no encontrada"));
	}

	@Override
	public List<Cabecera> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}
	
	
	
	

}
