package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Detalles;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.DetallesJpa;

@Mapper(componentModel = "spring")

public interface IDetallesJpaMapper {
	
	      Detalles ToDomain(DetallesJpa entity);
	      DetallesJpa toEntity(Detalles detalles);
}
