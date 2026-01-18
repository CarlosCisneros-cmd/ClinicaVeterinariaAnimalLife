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

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IVeterinarioUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.IVeterinarioDtoMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.VeterinarioRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.VeterinarioResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/veterinario")
public class VeterinarioController {
	
	private final IVeterinarioUseCase veterinarioUseCase;
	private final IVeterinarioDtoMapper mapper;
	public VeterinarioController(IVeterinarioUseCase veterinarioUseCase, IVeterinarioDtoMapper mapper) {
		this.veterinarioUseCase = veterinarioUseCase;
		this.mapper = mapper;
	}
	
@PostMapping
@ResponseStatus(HttpStatus.CREATED)

	public VeterinarioResponseDto crear(@Valid @RequestBody VeterinarioRequestDto request) {
	return mapper.toResponseDto(veterinarioUseCase.crear(mapper.toDomain(request)));
}
	
	@GetMapping
	public List<VeterinarioResponseDto> listar(){
		return veterinarioUseCase.listar()
				.stream()
				.map(mapper::toResponseDto).toList();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable int id){
		veterinarioUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
