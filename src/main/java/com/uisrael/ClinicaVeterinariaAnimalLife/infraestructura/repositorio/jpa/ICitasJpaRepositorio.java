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

	@Query("SELECT c FROM CitasJpa c WHERE c.fkVeterinario.nombre = :nombre AND c.fecha_Hora = :fecha_Hora")
	List<CitasJpa> buscarCitasPorVeterinarioyFecha(
	    @Param("nombre") String nombre, 
	    @Param("fecha_Hora") LocalDateTime fecha_Hora
	);

	
	@Query("SELECT COUNT(c) FROM CitasJpa c " +
	           "WHERE c.fkVeterinario.idveterinario = :idVeterinario " + 
	           "AND c.fecha_Hora BETWEEN :horaInicio AND :horaFin " +
	           "AND c.estado = true")
	    Long contarCitasEnHorario(@Param("idVeterinario") int idVeterinario, 
	                              @Param("horaInicio") LocalDateTime horaInicio, 
	                              @Param("horaFin") LocalDateTime horaFin);
}
