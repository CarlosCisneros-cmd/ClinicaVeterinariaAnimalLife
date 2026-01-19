package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.VeterinarioJpa;


public interface IVeterinarioJpaRepositorio extends JpaRepository <VeterinarioJpa, Integer> {

	
	
	@Query("SELECT v FROM VeterinarioJpa v WHERE v.apellido = :apellido")
    List<VeterinarioJpa> buscarPorApellido(@Param("apellido") String apellido);
}
