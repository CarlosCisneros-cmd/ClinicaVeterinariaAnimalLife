package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;


import org.mapstruct.Mapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Clientes;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.ClienteRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.ClienteResponseDto;

@Mapper(componentModel = "spring")

public interface IClienteDtoMapper {

	Clientes toDomain(ClienteRequestDto entity);
	ClienteResponseDto toResponseDto(Clientes clientes);

	
}


