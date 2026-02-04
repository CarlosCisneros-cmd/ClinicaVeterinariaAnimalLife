package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.VeterinarioRequestDto;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.VeterinarioResponseDto;

@Mapper(componentModel = "spring")
public interface IVeterinarioDtoMapper {
	
	@Mapping(target = "estado", constant = "true")
	Veterinario toDomain(VeterinarioRequestDto entity);
	VeterinarioResponseDto toResponseDto(Veterinario veterinario);
	

}
