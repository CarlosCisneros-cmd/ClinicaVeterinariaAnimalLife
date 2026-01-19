package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;


import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.VeterinarioRequestDto;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.VeterinarioResponseDto;

@Mapper(componentModel = "spring")
public interface IVeterinarioDtoMapper {

	Veterinario toDomain(VeterinarioRequestDto entity);
	VeterinarioResponseDto toResponseDto(Veterinario veterinario);
	

}
