package com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;

public interface IVeterinarioRepositorio {
	
    Veterinario guardar(Veterinario veterinario);
    Optional<Veterinario> buscarPorId(int id);
    List<Veterinario> listarTodos();
    void eliminar(int id);

    List<Veterinario> buscarPorApellido(String apellido);
    
    
    boolean existePorCedula(String cedula);
    boolean existePorCorreo(String correo);

    
    List<Veterinario> buscarPorCedulaLista(String cedula);
    List<Veterinario> buscarPorCorreoLista(String correo);

    
    List<Veterinario> listarInactivos();
    void activar(int id);
}
