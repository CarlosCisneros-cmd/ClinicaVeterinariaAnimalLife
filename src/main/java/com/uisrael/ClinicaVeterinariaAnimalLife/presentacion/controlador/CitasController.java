package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.controlador;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.*;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.ICitaDtoMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.CitasRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.CitasResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

	
	private final ICitaUseCase citaUseCase;
	private final ICitaDtoMapper mapper;
	
	
	public CitasController(ICitaUseCase citaUseCase, ICitaDtoMapper mapper) {
		this.citaUseCase = citaUseCase;
		this.mapper = mapper;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CitasResponseDto crear(@Valid @RequestBody CitasRequestDto request) {
		return mapper .toResponseDto(citaUseCase.crear(mapper.todomain(request))); 
		
	}
	
	@GetMapping
	public List<CitasResponseDto>listar(){ 
		return citaUseCase.listar().stream().map(mapper::toResponseDto).toList();
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable int id){
		citaUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/buscar-rango/{inicio}/{fin}")
	public ResponseEntity<List<CitasResponseDto>> buscarPorRango(
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
	    
	    List<CitasResponseDto> lista = citaUseCase.buscarPorRango(inicio, fin)
	            .stream()
	            .map(mapper::toResponseDto) 
	            .toList();
	            
	    return ResponseEntity.ok(lista);
	}
}
