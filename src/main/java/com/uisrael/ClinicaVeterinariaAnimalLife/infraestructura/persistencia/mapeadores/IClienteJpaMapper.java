package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores;


import org.mapstruct.Mapper;


import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Clientes;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.ClientesJpa;

@Mapper(componentModel = "spring")
public interface IClienteJpaMapper {

	
	
	Clientes toDomain(ClientesJpa entity);
	ClientesJpa toEntity(Clientes clientes);
	
}

