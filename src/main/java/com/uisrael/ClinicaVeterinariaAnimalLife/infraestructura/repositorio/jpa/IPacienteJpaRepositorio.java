package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.PacienteJpa;





public interface IPacienteJpaRepositorio extends JpaRepository<PacienteJpa, Integer>{

	@Query("SELECT p FROM PacienteJpa p WHERE p.especie = :especie")
	List<PacienteJpa> buscarPorEspecie(@Param("especie") String especie);

	
}
