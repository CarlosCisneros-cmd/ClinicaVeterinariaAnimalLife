package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.ClientesJpa;

public interface IClientesJpaRepositorio extends JpaRepository<ClientesJpa, Integer> {

    
    @Query("SELECT c FROM ClientesJpa c WHERE c.estado = true")
    List<ClientesJpa> listarSoloActivos();

 
    @Query("SELECT c FROM ClientesJpa c WHERE c.estado = false")
    List<ClientesJpa> buscarSoloInactivos();

    @Query("SELECT c FROM ClientesJpa c WHERE c.nombres = :nombres AND c.correo = :correo")
    List<ClientesJpa> buscarPorNombresyCorreo(@Param("nombres") String nombres, @Param("correo") String correo);

    boolean existsByCedula(String cedula);

    boolean existsByCorreo(String correo);
    Optional<ClientesJpa> findByCedula(String cedula);
    Optional<ClientesJpa> findByCorreo(String correo);
}