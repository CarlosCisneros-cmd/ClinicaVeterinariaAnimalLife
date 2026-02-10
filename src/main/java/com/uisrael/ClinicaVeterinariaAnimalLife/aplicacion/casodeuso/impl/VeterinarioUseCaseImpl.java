package com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IVeterinarioUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IVeterinarioRepositorio;

@Service
public class VeterinarioUseCaseImpl implements IVeterinarioUseCase {
	
    private final IVeterinarioRepositorio repositorio;

    public VeterinarioUseCaseImpl(IVeterinarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Veterinario crear(Veterinario veterinario) {
       
        List<Veterinario> vetsConCedula = repositorio.buscarPorCedulaLista(veterinario.getCedula());
        
        for (Veterinario v : vetsConCedula) {
           
            if (veterinario.getIdveterinario() == 0 || v.getIdveterinario() != veterinario.getIdveterinario()) {
                throw new RuntimeException("No se puede registrar: La cédula " + veterinario.getCedula() + " ya pertenece a otro veterinario.");
            }
        }
        
        
        List<Veterinario> vetsConCorreo = repositorio.buscarPorCorreoLista(veterinario.getCorreo());
        
        for (Veterinario v : vetsConCorreo) {
            
            if (veterinario.getIdveterinario() == 0 || v.getIdveterinario() != veterinario.getIdveterinario()) {
                throw new RuntimeException("No se puede registrar: El correo " + veterinario.getCorreo() + " ya está en uso por otro veterinario.");
            }
        }

        return repositorio.guardar(veterinario);
    }

    @Override
    public Veterinario obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado con ID: " + id));
    }

    @Override
    public List<Veterinario> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
	
    @Override
    public List<Veterinario> buscarPorApellido(String apellido) {
        return repositorio.buscarPorApellido(apellido);
    }

  
}
