package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.CitasJpa;

@Mapper(componentModel = "spring")
public interface ICitasJpaMapper {
	
	Citas ToDomain(CitasJpa entity);
	CitasJpa toEntity(Citas citas);
	

}
