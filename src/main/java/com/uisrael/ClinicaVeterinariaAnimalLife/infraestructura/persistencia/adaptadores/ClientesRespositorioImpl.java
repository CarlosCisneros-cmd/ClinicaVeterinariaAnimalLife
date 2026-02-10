package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Clientes;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IClientesRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.ClientesJpa;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IClientesJpaRepositorio;

public class ClientesRespositorioImpl implements IClientesRepositorio {

    private final IClientesJpaRepositorio jpaRepository;
    private final IClienteJpaMapper entityMapper;

    public ClientesRespositorioImpl(IClientesJpaRepositorio jpaRepository, IClienteJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Clientes guardar(Clientes clientes) {
        ClientesJpa entity = entityMapper.toEntity(clientes);
        ClientesJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<Clientes> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<Clientes> listarTodos() {
        // CAMBIO: Ahora usamos el método filtrado para no mezclar con la papelera
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
    public List<Clientes> buscarPorNombresyCorreo(String nombres, String correo) {
        return jpaRepository.buscarPorNombresyCorreo(nombres, correo)
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
    public List<Clientes> listarInactivos() {
       
        return jpaRepository.buscarSoloInactivos()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public void activar(int id) {
        jpaRepository.findById(id).ifPresent(cliente -> {
            cliente.setEstado(true); 
            jpaRepository.save(cliente);
        });
    }
}