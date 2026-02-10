package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IVeterinarioRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.VeterinarioJpa;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IVeterinarioJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IVeterinarioJpaRepositorio;

public class VeterinarioRepositorioImpl implements IVeterinarioRepositorio {
	
    private final IVeterinarioJpaRepositorio jpaRepository;
    private final IVeterinarioJpaMapper entityMapper;
	
    public VeterinarioRepositorioImpl(IVeterinarioJpaRepositorio jpaRepository, IVeterinarioJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        VeterinarioJpa entity = entityMapper.toEntity(veterinario);
        VeterinarioJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<Veterinario> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<Veterinario> listarTodos() {
        
        return jpaRepository.listarSoloActivos()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(int id) {
        
        jpaRepository.deleteById(id);
    }
	
    @Override
    public List<Veterinario> buscarPorApellido(String apellido) {
        return jpaRepository.buscarPorApellido(apellido)
                .stream()
                .map(entityMapper::toDomain) 
                .toList();
    }
	
    @Override
    public boolean existePorCedula(String cedula) {
        return jpaRepository.existsByCedula(cedula);
    }

    @Override
    public boolean existePorCorreo(String correo) {
        return jpaRepository.existsByCorreo(correo);
    }

   
    @Override
    public List<Veterinario> buscarPorCedulaLista(String cedula) {
        return jpaRepository.findByCedula(cedula).stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    
    @Override
    public List<Veterinario> buscarPorCorreoLista(String correo) {
        return jpaRepository.findByCorreo(correo).stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    
    @Override
    public List<Veterinario> listarInactivos() {
        return jpaRepository.buscarSoloInactivos()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

  
    @Override
    public void activar(int id) {
        jpaRepository.findById(id).ifPresent(v -> {
            v.setEstado(true);
            jpaRepository.save(v);
        });
    }
}
