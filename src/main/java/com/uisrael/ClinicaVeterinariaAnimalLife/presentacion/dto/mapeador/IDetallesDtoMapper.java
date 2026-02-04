package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Detalles;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.DetallesRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.DetallesResponseDto;

@Mapper(componentModel = "spring", uses = { ICitaDtoMapper.class, IServicioDtoMapper.class }) 
public interface IDetallesDtoMapper {

    @Mapping(target = "fkCita.estado", constant = "true")
    @Mapping(target = "fkCita.fkVeterinario.estado", constant = "true")
    @Mapping(target = "fkCita.fkPaciente.estado", constant = "true")
    @Mapping(target = "fkCita.fkPaciente.fkCliente.estado", constant = "true")
    @Mapping(target = "fkCita.servicios", source = "fkCita.servicios")
    Detalles todomain(DetallesRequestDto dto);

    DetallesResponseDto toResponseDto(Detalles dominio);

  
  
}