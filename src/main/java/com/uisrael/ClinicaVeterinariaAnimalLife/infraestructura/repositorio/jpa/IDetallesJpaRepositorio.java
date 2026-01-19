package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.DetallesJpa;

public interface IDetallesJpaRepositorio extends JpaRepository<DetallesJpa, Integer>{
	
	@Query("SELECT d FROM DetallesJpa d WHERE d.cliente.nombres= :nombreCliente AND d.nombrePaciente= :nombrePaciente")
	List<DetallesJpa> buscarDetallePorClienteyPaciente(@Param("nombreCliente")String nombreCliente,@Param("nombrePaciente")String nombrePaciente);

}
