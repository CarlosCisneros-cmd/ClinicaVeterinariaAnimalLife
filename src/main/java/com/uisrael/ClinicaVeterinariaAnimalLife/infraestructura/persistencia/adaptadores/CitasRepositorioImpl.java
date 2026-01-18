package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.ICitasRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.CitasJpa;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.ICitasJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.ICitasJpaRepositorio;

public class CitasRepositorioImpl implements ICitasRepositorio {
	
	private final ICitasJpaRepositorio jpaRepository;
	private final ICitasJpaMapper entityMapper;
	

	public CitasRepositorioImpl(ICitasJpaRepositorio jpaRepository, ICitasJpaMapper entityMapper) {
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public Citas guardar(Citas citas) {
		CitasJpa entity = entityMapper.toEntity(citas);
		CitasJpa guardado = jpaRepository.save(entity);
		return entityMapper.ToDomain(guardado);
	}

	@Override
	public Optional<Citas> buscarPorId(int id) {
		return jpaRepository.findById(id)
				.map(entityMapper::ToDomain);
	}

	@Override
	public List<Citas> listarTodos() {
		return jpaRepository.findAll()
				.stream().map(entityMapper::ToDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
		
	}

}
