package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.CitasRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.CitasResponseDto;

@Mapper(componentModel = "spring")
public interface ICitaDtoMapper {
	
	Citas todomain(CitasRequestDto dto);
	CitasResponseDto toResponseDto(Citas cita);
	

}
