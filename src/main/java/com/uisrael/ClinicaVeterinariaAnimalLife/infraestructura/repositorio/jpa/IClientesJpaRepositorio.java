package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;




import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.ClientesJpa;

public interface IClientesJpaRepositorio extends JpaRepository<ClientesJpa, Integer> {

	
	@Query("SELECT c FROM ClientesJpa c WHERE c.nombres= :nombres AND c.correo= :correo")
	List<ClientesJpa> buscarPorNombresyCorreo(@Param("nombres")String nombres,@Param("correo")String correo);



	
}
