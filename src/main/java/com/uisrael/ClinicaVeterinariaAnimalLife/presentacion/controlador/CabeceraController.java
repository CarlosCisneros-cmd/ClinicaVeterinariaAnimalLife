package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.controlador;

import java.util.List;

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

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.ICabeceraUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.ICabeceraDtoMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.CabeceraRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.CabeceraResponseDto;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/cabecera")
public class CabeceraController {
	
	private final ICabeceraUseCase cabeceraUseCase;
	private final ICabeceraDtoMapper mapper;
	
	
	public CabeceraController(ICabeceraUseCase cabeceraUseCase, ICabeceraDtoMapper mapper) {
		super();
		this.cabeceraUseCase = cabeceraUseCase;
		this.mapper = mapper;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CabeceraResponseDto crear(@Valid @RequestBody CabeceraRequestDto request) {
		return mapper.toResponseDto(cabeceraUseCase.crear(mapper.todomain(request)));
		
	}
	
	@GetMapping
	public List<CabeceraResponseDto> listar(){ 
		return cabeceraUseCase.listar().stream().map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable int id){
		cabeceraUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CabeceraResponseDto> obtenerPorId(@PathVariable int id) {
	    CabeceraResponseDto response = mapper.toResponseDto(cabeceraUseCase.obtenerPorId(id));
	    return ResponseEntity.ok(response);
	}

}
