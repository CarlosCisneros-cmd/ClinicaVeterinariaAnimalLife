package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Servicio;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IServicioRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.ServicioJpa;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IServicioJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IServicioJpaRepositorio;

public class ServicioRepositorioImpl implements IServicioRepositorio {
	
	private final IServicioJpaRepositorio jpaRepository;
	private final IServicioJpaMapper entityMapper;
	

	
	
		

	public ServicioRepositorioImpl(IServicioJpaRepositorio jpaRepository, IServicioJpaMapper entityMapper) {
		

		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}
	@Override
	public Servicio guardar(Servicio servicio) {
		ServicioJpa entity=entityMapper.toEntity(servicio);
		ServicioJpa guardado = jpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}
	@Override
	public Optional<Servicio> buscarPorId(int id) {
		return jpaRepository.findById(id)
				.map(entityMapper::toDomain);
	}
	@Override
	public List<Servicio> listarTodos() {
		return jpaRepository.findAll()
				.stream()
				.map(entityMapper::toDomain)
				.toList();
	}
	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
		
	}
	
	

}
