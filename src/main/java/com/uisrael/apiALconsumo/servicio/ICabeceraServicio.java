package com.uisrael.apiALconsumo.servicio;

import java.util.List;

import com.uisrael.apiALconsumo.modelo.dto.request.CabeceraRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.CabeceraResponseDto;

public interface ICabeceraServicio {
	public List<CabeceraResponseDto>Listarcabecera();
	public void crearCabecera(CabeceraRequestDto dto);
	CabeceraResponseDto buscarPorId(int id);

}
