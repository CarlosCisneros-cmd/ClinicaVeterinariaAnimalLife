package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;

import java.util.List;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IPacienteUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Paciente;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IPacienteRepositorio;

public class PacienteUseCaseImpl implements IPacienteUseCase{

	private final IPacienteRepositorio repositorio;

	public PacienteUseCaseImpl(IPacienteRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Paciente crear(Paciente paciente) {
		// TODO Auto-generated method stub
		return repositorio.guardar(paciente);
	}

	@Override
	public Paciente obtenerPoriD(int id) {
		// TODO Auto-generated method stub
		return repositorio.bucarPorId(id)
				.orElseThrow(() ->
				new RuntimeException("Paciente no encontrado"));
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repositorio.eliminar(id);
		
	}
	@Override
	public List<Paciente> buscarPorEspecie(String especie) {
	    return repositorio.buscarPorEspecie(especie);
	}

	@Override
	public List<Paciente> buscarPacientesPorNombreVeterinario(String nombreVeterinario) {
		return repositorio.buscarPacientesPorNombreVeterinario(nombreVeterinario);
		
	}
}
