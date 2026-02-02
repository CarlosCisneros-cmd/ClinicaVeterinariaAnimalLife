package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;



import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Servicio;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.ServicioRequestDto;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.ServicioResponseDto;

@Mapper(componentModel = "spring")

public interface IServicioDtoMapper {

	Servicio toDomain(ServicioRequestDto dto);
	ServicioResponseDto toResponseDto(Servicio servicio);	
}
