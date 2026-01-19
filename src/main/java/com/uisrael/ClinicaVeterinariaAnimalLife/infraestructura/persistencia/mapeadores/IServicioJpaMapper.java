package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Servicio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.ServicioJpa;

@Mapper(componentModel="spring")
public interface IServicioJpaMapper {
	
	Servicio toDomain(ServicioJpa entity);
	ServicioJpa toEntity(Servicio servicio);
	

}
