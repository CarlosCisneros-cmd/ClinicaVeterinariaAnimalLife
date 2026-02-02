package com.uisrael.apiALconsumo.servicio;

import java.util.List;

import com.uisrael.apiALconsumo.modelo.dto.request.ServicioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ServicioResponseDto;

public interface IServicioServicio {
	
	public List<ServicioResponseDto>listarServicio();
	public void crearServicio(ServicioRequestDto dto);

}
