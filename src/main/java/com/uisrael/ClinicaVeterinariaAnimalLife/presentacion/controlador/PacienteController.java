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

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IPacienteUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.IPacienteDtoMapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.PacienteRequestDTO;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.PacienteResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

	private final IPacienteUseCase pacienteUseCase;
	private final IPacienteDtoMapper mapper;
	
	public PacienteController(IPacienteUseCase pacienteUseCase, IPacienteDtoMapper mapper) {
		super();
		this.pacienteUseCase = pacienteUseCase;
		this.mapper = mapper;
	}

	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteResponseDTO crear(@Valid @RequestBody PacienteRequestDTO request) {

        return mapper.toResponseDto(pacienteUseCase.crear(mapper.toDomain(request)));
    }
	@GetMapping
	public List<PacienteResponseDTO> listar(){
		
	return pacienteUseCase.listar().stream().map(mapper::toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable int id){
		pacienteUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/especie/{especie}")
	public ResponseEntity<List<PacienteResponseDTO>> buscarPorEspecie(@PathVariable String especie) {
	    List<PacienteResponseDTO> lista = pacienteUseCase.buscarPorEspecie(especie)
	            .stream()
	            .map(mapper::toResponseDto)
	            .toList();
	    return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/buscar-por-veterinario/{nombre}")
    public ResponseEntity<List<PacienteResponseDTO>> buscarPorVeterinario(@PathVariable String nombre) {
        List<PacienteResponseDTO> lista = pacienteUseCase.buscarPacientesPorNombreVeterinario(nombre)
		        .stream()
		        .map(mapper::toResponseDto)
		        .toList();
		return ResponseEntity.ok(lista);
  
    }
	
	@GetMapping("/buscar-por-cliente/{nombre}")
	public ResponseEntity<List<PacienteResponseDTO>> buscarPorCliente(@PathVariable String nombre) {
	    List<PacienteResponseDTO> lista = pacienteUseCase.buscarPacientesPorNombreCliente(nombre)
	    		.stream()
		        .map(mapper::toResponseDto)
		        .toList();
		return ResponseEntity.ok(lista);
	 
	}
}
	
		

	

