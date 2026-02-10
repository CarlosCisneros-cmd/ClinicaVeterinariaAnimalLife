package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IClienteUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Clientes;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IClientesRepositorio;

@Service
public class ClienteUseCaseImpl implements IClienteUseCase {

    private final IClientesRepositorio repositorio;

    public ClienteUseCaseImpl(IClientesRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Clientes crear(Clientes cliente) {
       
        Optional<Clientes> clienteConMismaCedula = repositorio.buscarPorCedula(cliente.getCedula());
        
        
        if (clienteConMismaCedula.isPresent() && 
           (cliente.getIdCliente() == 0 || clienteConMismaCedula.get().getIdCliente() != cliente.getIdCliente())) {
            throw new RuntimeException("No se puede registrar: La cédula " + cliente.getCedula() + " ya pertenece a otro cliente.");
        }

     
        Optional<Clientes> clienteConMismoCorreo = repositorio.buscarPorCorreo(cliente.getCorreo());
        
        if (clienteConMismoCorreo.isPresent() && 
           (cliente.getIdCliente() == 0 || clienteConMismoCorreo.get().getIdCliente() != cliente.getIdCliente())) {
            throw new RuntimeException("No se puede registrar: El correo " + cliente.getCorreo() + " ya está en uso por otro cliente.");
        }
        
        return repositorio.guardar(cliente);
    }

    @Override
    public Clientes obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public List<Clientes> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }

    @Override
    public List<Clientes> buscarPorNombresyCorreo(String nombres, String correo) {
        return repositorio.buscarPorNombresyCorreo(nombres, correo);
    }

    @Override
    public List<Clientes> listarInactivos() {
        return repositorio.listarInactivos();
    }

    @Override
    public void recuperar(int id) {
        repositorio.activar(id);
    }
}