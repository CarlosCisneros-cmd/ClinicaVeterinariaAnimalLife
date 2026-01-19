package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores;


import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Paciente;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IPacienteRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.PacienteJpa;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IPacienteJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IPacienteJpaRepositorio;

public class PacienteRepositorioImpl implements IPacienteRepositorio {

	private final IPacienteJpaRepositorio jpaRepository;
	private final IPacienteJpaMapper entityMapper;
	public PacienteRepositorioImpl(IPacienteJpaRepositorio jpaRepository, IPacienteJpaMapper entityMapper) {
		super();
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}
	@Override
	public Paciente guardar(Paciente paciente) {
		PacienteJpa entity = entityMapper.toEntity(paciente);
		PacienteJpa guardado = jpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}
	@Override
	public Optional<Paciente> bucarPorId(int id) {
		return jpaRepository.findById(id)
				.map(entityMapper::toDomain);
	}
	@Override
	public List<Paciente> listarTodos() {
		return jpaRepository.findAll()
				.stream()
				.map(entityMapper::toDomain)
				.toList();
	}
	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
		
	}
	
	@Override
	public List<Paciente> buscarPorEspecie(String especie) {
	    return jpaRepository.buscarPorEspecie(especie)
	            .stream()
	            .map(entityMapper::toDomain)
	            .toList();
	}
	@Override
	public List<Paciente> buscarPacientesPorNombreVeterinario(String nombreVeterinario) {
		 return jpaRepository.buscarPacientesPorNombreVeterinario(nombreVeterinario)
		            .stream()
		            .map(entityMapper::toDomain)
		            .toList();
	}
	@Override
	public List<Paciente> buscarPacientesPorNombreCliente(String nombreCliente) {
		return jpaRepository.buscarPacientesPorNombreCliente(nombreCliente)
	            .stream()
	            .map(entityMapper::toDomain)
	            .toList();
	}
	
	
	
	
	
}
