package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Paciente;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.PacienteJpa;

@Mapper(componentModel = "spring")
public interface IPacienteJpaMapper {

	Paciente toDomain(PacienteJpa entity);
	PacienteJpa toEntity(Paciente paciente);
	
}
