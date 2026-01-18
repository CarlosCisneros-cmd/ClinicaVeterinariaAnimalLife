package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.VeterinarioJpa;

@Mapper(componentModel="spring")
public interface IVeterinarioJpaMapper {
	
	Veterinario toDomain(VeterinarioJpa entity);
	VeterinarioJpa toEntity(Veterinario veterinario);

}
