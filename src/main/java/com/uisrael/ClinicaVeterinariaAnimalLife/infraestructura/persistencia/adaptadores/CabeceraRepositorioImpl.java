package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Cabecera;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.ICabeceraRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.CabeceraJpa;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.ICabeceraJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.ICabecerJpaRepositorio;


public class CabeceraRepositorioImpl implements ICabeceraRepositorio{
	
	private final ICabecerJpaRepositorio jpaRepository;
	private final ICabeceraJpaMapper entityMapper;
	
	public CabeceraRepositorioImpl(ICabecerJpaRepositorio jpaRepository, ICabeceraJpaMapper entityMapper) {
		super();
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}
	
	
	
	
	@Override
	public Cabecera guardar(Cabecera cabecera) {
		CabeceraJpa entity = entityMapper.toEntity(cabecera);
		CabeceraJpa guardado = jpaRepository.save(entity);
		return entityMapper.ToDomain(guardado);
	}
	@Override
	public Optional<Cabecera> buscarPorId(int id) {
		return jpaRepository.findById(id)
				.map(entityMapper::ToDomain);
	}
	@Override
	public List<Cabecera> listarTodos() {
		return jpaRepository.findAll()
				.stream().map(entityMapper::ToDomain).toList();
	}
	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
		
	}

}
