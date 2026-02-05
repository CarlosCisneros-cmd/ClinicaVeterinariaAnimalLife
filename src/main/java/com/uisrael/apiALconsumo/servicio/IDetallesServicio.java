package com.uisrael.apiALconsumo.servicio;

import java.util.List;

import com.uisrael.apiALconsumo.modelo.dto.request.DetallesRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.DetallesResponseDto;



public interface IDetallesServicio {
	
	public List<DetallesResponseDto>listarDetalles();
	public void crearDetalles(DetallesRequestDto dto);
	public DetallesResponseDto buscarPorId(int id);
	public void eliminarDetalle(int id);
	DetallesResponseDto obtenerPorId(int id);
}
