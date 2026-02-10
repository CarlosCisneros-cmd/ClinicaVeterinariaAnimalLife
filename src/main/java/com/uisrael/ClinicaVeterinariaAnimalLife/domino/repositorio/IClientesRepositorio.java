package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Clientes;

public interface IClientesRepositorio {
	
    Clientes guardar(Clientes clientes);
    Optional<Clientes> buscarPorId(int id);
    List<Clientes> listarTodos();
    void eliminar(int id);

    List<Clientes> buscarPorNombresyCorreo (String nombres, String correo);

    
    boolean existePorCedula(String cedula);
    boolean existePorCorreo(String correo);

   
    Optional<Clientes> buscarPorCedula(String cedula);
    Optional<Clientes> buscarPorCorreo(String correo);
    
    List<Clientes> listarInactivos();
    void activar(int id);
}
