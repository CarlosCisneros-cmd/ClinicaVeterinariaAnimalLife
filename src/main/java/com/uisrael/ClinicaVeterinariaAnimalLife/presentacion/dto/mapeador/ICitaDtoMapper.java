package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Citas;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.entidades.Servicio; 
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.CitasRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.CitasResponseDto;

@Mapper(componentModel = "spring", uses = { 
    IPacienteDtoMapper.class, 
    IVeterinarioDtoMapper.class, 
    IServicioDtoMapper.class 
})
public interface ICitaDtoMapper {

    @Mapping(target = "estado", constant = "true") 
    @Mapping(target = "fkVeterinario.estado", constant = "true")
    @Mapping(target = "fkPaciente.estado", constant = "true")
    @Mapping(target = "fkPaciente.fkCliente.estado", constant = "true")
    @Mapping(target = "servicios", source = "servicios")
    Citas todomain(CitasRequestDto dto);

    CitasResponseDto toResponseDto(Citas cita);

    default Servicio mapIdToServicio(Integer id) {
        if (id == null) return null;
        return new Servicio(id, null, false);
    }
}