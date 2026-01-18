package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Veterinario;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.VeterinarioRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.VeterinarioResponseDto;

@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface IVeterinarioDtoMapper {
	
	Veterinario toDomain(VeterinarioRequestDto dto);
	VeterinarioResponseDto toResponseDto(Veterinario veterinario);

}
