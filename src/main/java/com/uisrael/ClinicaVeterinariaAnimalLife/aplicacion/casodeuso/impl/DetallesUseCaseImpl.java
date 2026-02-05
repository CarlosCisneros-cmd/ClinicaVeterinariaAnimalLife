package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;
import java.time.LocalDateTime;
import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IDetallesUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Detalles;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IDetallesRepositorio;

public class DetallesUseCaseImpl implements IDetallesUseCase{
private final IDetallesRepositorio repositorio;
	

	public DetallesUseCaseImpl(IDetallesRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	
	@Override
    public Detalles crear(Detalles detalles) {
            detalles.setFechaCreacion(LocalDateTime.now());
        return repositorio.guardar(detalles);
	}

	@Override
	public Detalles obtenerPorId  (int id) {
		return repositorio.buscarPorId(id).orElseThrow(() 
				->new RuntimeException("Detalles no encontrados"));
	}

	@Override
	public List<Detalles> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}

	@Override
	public List<Detalles> buscarDetallePorClienteyPaciente(String nombreCliente, String nombrePaciente) {
		return repositorio.buscarDetallePorClienteyPaciente(nombreCliente,nombrePaciente);
	}


	
	
}
