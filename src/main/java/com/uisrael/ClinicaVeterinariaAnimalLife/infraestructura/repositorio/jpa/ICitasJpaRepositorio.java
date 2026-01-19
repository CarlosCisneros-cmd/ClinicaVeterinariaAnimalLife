package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.CitasJpa;

public interface ICitasJpaRepositorio extends JpaRepository<CitasJpa, Integer>{

	
	@Query("SELECT c FROM CitasJpa c WHERE c.fecha_Hora BETWEEN :inicio AND :fin")
    List<CitasJpa> buscarPorRango(@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin);

	
	
	@Query("SELECT c FROM CitasJpa WHERE c.veterinario.nombre= :nombre AND c.fecha_Hora= :fecha_hora")
	List<CitasJpa> buscarCitasPorVeterinarioyFecha (@Param ("nombre")String nombre, @Param("fecha_Hora") LocalDateTime fecha_Hora);

}
