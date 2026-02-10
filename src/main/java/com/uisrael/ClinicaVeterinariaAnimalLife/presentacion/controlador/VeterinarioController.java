package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IVeterinarioUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.IVeterinarioDtoMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.VeterinarioRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.VeterinarioResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/veterinarios") 
public class VeterinarioController {
	
	private final IVeterinarioUseCase veterinarioUseCase;
	private final IVeterinarioDtoMapper mapper;

	public VeterinarioController(IVeterinarioUseCase veterinarioUseCase, IVeterinarioDtoMapper mapper) {
		this.veterinarioUseCase = veterinarioUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody VeterinarioRequestDto request) {
		try {
			// Intentamos crear el veterinario
			VeterinarioResponseDto response = mapper.toResponseDto(
				veterinarioUseCase.crear(mapper.toDomain(request))
			);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			
			Map<String, String> error = new HashMap<>();
			error.put("mensaje", e.getMessage());
			return ResponseEntity.badRequest().body(error);
		}
	}
	
	@GetMapping
	public List<VeterinarioResponseDto> listar(){
		return veterinarioUseCase.listar()
				.stream()
				.map(mapper::toResponseDto)
				.toList();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable int id){
		veterinarioUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/apellido/{apellido}")
	public ResponseEntity<List<VeterinarioResponseDto>> buscarPorApellido(@PathVariable String apellido) {
	    List<VeterinarioResponseDto> lista = veterinarioUseCase.buscarPorApellido(apellido)
	            .stream()
	            .map(mapper::toResponseDto)
	            .toList();
	    return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/buscarid/{idVeterinario}")
	public VeterinarioResponseDto buscarPorId(@PathVariable int idVeterinario) {
		return mapper.toResponseDto(veterinarioUseCase.obtenerPorId(idVeterinario));
	}
}
