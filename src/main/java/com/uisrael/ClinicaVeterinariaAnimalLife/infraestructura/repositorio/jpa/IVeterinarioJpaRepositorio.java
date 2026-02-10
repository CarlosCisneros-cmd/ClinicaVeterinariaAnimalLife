package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.VeterinarioJpa;

public interface IVeterinarioJpaRepositorio extends JpaRepository <VeterinarioJpa, Integer> {

    @Query("SELECT v FROM VeterinarioJpa v WHERE v.apellido = :apellido")
    List<VeterinarioJpa> buscarPorApellido(@Param("apellido") String apellido);
    
   
    boolean existsByCedula(String cedula);
    boolean existsByCorreo(String correo);

 
    List<VeterinarioJpa> findByCedula(String cedula);
    List<VeterinarioJpa> findByCorreo(String correo);

    
    @Query("SELECT v FROM VeterinarioJpa v WHERE v.estado = true")
    List<VeterinarioJpa> listarSoloActivos();

    @Query("SELECT v FROM VeterinarioJpa v WHERE v.estado = false")
    List<VeterinarioJpa> buscarSoloInactivos();
}
