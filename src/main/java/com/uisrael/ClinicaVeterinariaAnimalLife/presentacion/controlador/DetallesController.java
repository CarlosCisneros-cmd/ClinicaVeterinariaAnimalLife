package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IDetallesUseCase;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.IDetallesDtoMapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.DetallesRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.DetallesResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalles")

public class DetallesController {
	
	private final IDetallesUseCase detallesUseCase;
	private final IDetallesDtoMapper mapper;
	
	
	public DetallesController(IDetallesUseCase detallesUseCase, IDetallesDtoMapper mapper) {
		super();
		this.detallesUseCase = detallesUseCase;
		this.mapper = mapper;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetallesResponseDto crear(@Valid @RequestBody DetallesRequestDto request) {
		return mapper.toResponseDto(detallesUseCase.crear(mapper.todomain(request)));
		
	}
	
	@GetMapping
	public List<DetallesResponseDto> listar(){ 
		return detallesUseCase.listar().stream().map(mapper::toResponseDto).toList();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<DetallesResponseDto> obtenerPorId(@PathVariable int id) {
        DetallesResponseDto response = mapper.toResponseDto(detallesUseCase.obtenerPorId(id));
        return ResponseEntity.ok(response);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable int id){
		detallesUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/buscar-cliente-paciente/{nombreCliente}/{nombrePaciente}")
	public ResponseEntity<List<DetallesResponseDto>> buscarDetallePorClienteyPaciente(
	    @PathVariable String nombreCliente,
	    @PathVariable String nombrePaciente) {
	    
	    List<DetallesResponseDto> lista = detallesUseCase.buscarDetallePorClienteyPaciente(nombreCliente, nombrePaciente)
	            .stream()
	            .map(mapper::toResponseDto) 
	            .toList();
	            
	    return ResponseEntity.ok(lista);
	}
	@PutMapping("/{id}")
	public ResponseEntity<DetallesResponseDto> actualizar(@PathVariable int id, @Valid @RequestBody DetallesRequestDto request) {
	    var detalleDominio = mapper.todomain(request);
	    detalleDominio.setIdDetalles(id); 
	    var actualizado = detallesUseCase.crear(detalleDominio); 
	    return ResponseEntity.ok(mapper.toResponseDto(actualizado));
	}

	@GetMapping("/por-cabecera/{idCabecera}")
	public ResponseEntity<List<DetallesResponseDto>> listarPorCabecera(@PathVariable int idCabecera) {
	    List<DetallesResponseDto> lista = detallesUseCase.listarPorCabecera(idCabecera)
	            .stream()
	            .map(mapper::toResponseDto)
	            .toList();
	    return ResponseEntity.ok(lista);
	}

}
