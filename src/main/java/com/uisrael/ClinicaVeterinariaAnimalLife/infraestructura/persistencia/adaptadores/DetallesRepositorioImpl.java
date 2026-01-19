package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;


import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Detalles;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IDetallesRepositorio;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.DetallesJpa;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IDetallesJpaMapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IDetallesJpaRepositorio;

public class DetallesRepositorioImpl implements IDetallesRepositorio {

	private final IDetallesJpaRepositorio jpaRepository;
	private final IDetallesJpaMapper entityMapper;
	
	public DetallesRepositorioImpl(IDetallesJpaRepositorio jpaRepository, IDetallesJpaMapper entityMapper) {
		super();
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}
	
	
	
	
	@Override
	public Detalles guardar(Detalles detalles) {
		DetallesJpa entity = entityMapper.toEntity(detalles);
		DetallesJpa guardado = jpaRepository.save(entity);
		return entityMapper.ToDomain(guardado);
	}
	@Override
	public Optional<Detalles> buscarPorId(int id) {
		return jpaRepository.findById(id)
				.map(entityMapper::ToDomain);
	}
	@Override
	public List<Detalles> listarTodos() {
		return jpaRepository.findAll()
				.stream().map(entityMapper::ToDomain).toList();
	}
	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
		
	}

	@Override
	public List<Detalles> buscarDetallePorClienteyPaciente(String nombreCliente, String nombrePaciente) {
		return jpaRepository.buscarDetallePorClienteyPaciente(nombreCliente, nombrePaciente)
				.stream()
				.map(entityMapper::ToDomain)
				.toList();
	}

}
