package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Detalles;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.DetallesRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.DetallesResponseDto;

@Mapper(componentModel = "spring")

public interface IDetallesDtoMapper {
	
	Detalles todomain(DetallesRequestDto dto);
	DetallesResponseDto toResponseDto(Detalles detalles);
	
}
