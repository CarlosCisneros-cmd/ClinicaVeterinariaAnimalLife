package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;


import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Paciente;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.PacienteRequestDTO;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.PacienteResponseDTO;

@Mapper(componentModel = "spring")
public interface IPacienteDtoMapper {

	Paciente toDomain(PacienteRequestDTO entity);
	PacienteResponseDTO toResponseDto(Paciente paciente);
	

}
