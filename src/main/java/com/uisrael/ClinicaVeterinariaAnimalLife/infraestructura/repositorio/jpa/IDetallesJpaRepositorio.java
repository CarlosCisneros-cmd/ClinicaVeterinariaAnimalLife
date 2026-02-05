package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.DetallesJpa;

public interface IDetallesJpaRepositorio extends JpaRepository<DetallesJpa, Integer>{

	
	@Query("SELECT d FROM DetallesJpa d " +
		       "JOIN d.fkCabecera c " +
		       "JOIN d.fkCita ci " +
		       "JOIN ci.fkPaciente p " +
		       "WHERE c.nombreCliente = :nombreCliente AND p.raza = :nombrePaciente")
		List<DetallesJpa> buscarDetallePorClienteyPaciente(
		    @Param("nombreCliente") String nombreCliente, 
		    @Param("nombrePaciente") String nombrePaciente
		);
	@Query("SELECT d FROM DetallesJpa d " +
	           "JOIN d.fkCita ci " +
	           "JOIN ci.fkPaciente p " +
	           "WHERE p.idPaciente = :idPaciente")
	    List<DetallesJpa> findByPacienteIdPaciente(@Param("idPaciente") int idPaciente);
}
