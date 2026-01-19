package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Cabecera;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.CabeceraRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.CabeceraResponseDto;


@Mapper(componentModel = "spring")
public interface ICabeceraDtoMapper {
	
	Cabecera todomain(CabeceraRequestDto dto);
	CabeceraResponseDto toResponseDto (Cabecera cabecera);

	
}

