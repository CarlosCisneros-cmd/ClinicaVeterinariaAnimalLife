package com.uisrael.apiALconsumo.servicio;

import java.util.List;

import com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.VeterinarioResponseDto;

public interface IVeterinarioServicio {

	
	public void crearVeterinario(VeterinarioRequestDto dto);
	public List<VeterinarioResponseDto> listarVeterinario();

}
