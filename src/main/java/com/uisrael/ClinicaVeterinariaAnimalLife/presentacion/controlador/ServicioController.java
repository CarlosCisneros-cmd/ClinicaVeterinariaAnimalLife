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

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IServicioUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.IServicioDtoMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.ServicioRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.ServicioResponseDto;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
	
	private final IServicioUseCase servicioUseCase;
	private final IServicioDtoMapper mapper;
	public ServicioController(IServicioUseCase servicioUseCase, IServicioDtoMapper mapper) {
		this.servicioUseCase = servicioUseCase;
		this.mapper = mapper;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicioResponseDto crear(@Valid @RequestBody ServicioRequestDto request) {
		return mapper.toResponseDto(servicioUseCase.crear(mapper.toDomain(request)));
	}
	@GetMapping
	public List<ServicioResponseDto> listar(){
		return servicioUseCase.listar()
				.stream()
				.map(mapper::toResponseDto).toList();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable int id){
		servicioUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
