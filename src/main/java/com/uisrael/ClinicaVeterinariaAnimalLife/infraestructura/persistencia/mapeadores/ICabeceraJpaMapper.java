package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Cabecera;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.CabeceraJpa;

@Mapper(componentModel = "spring")
public interface ICabeceraJpaMapper {

		Cabecera ToDomain(CabeceraJpa entity);
		CabeceraJpa toEntity(Cabecera cabecera);

}
