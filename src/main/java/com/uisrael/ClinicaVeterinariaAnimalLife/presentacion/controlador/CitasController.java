package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.controlador;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<?> crear(@Valid @RequestBody CitasRequestDto request) {
        try {
            // Mapeamos a dominio, creamos y mapeamos a respuesta
            var nuevaCita = citaUseCase.crear(mapper.todomain(request));
            return new ResponseEntity<>(mapper.toResponseDto(nuevaCita), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Capturamos el error de fecha pasada o cualquier validación del UseCase
            Map<String, String> error = new HashMap<>();
            // Usamos 'mensaje' como llave para que coincida con lo que busca el proyecto de consumo
            error.put("mensaje", e.getMessage()); 
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping
    public List<CitasResponseDto> listar() {
        return citaUseCase.listar().stream().map(mapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
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

    @GetMapping("/buscar-veterinario-fecha/{nombre}/{fecha}")
    public ResponseEntity<List<CitasResponseDto>> buscarCitasPorVeterinarioyFecha(
            @PathVariable String nombre,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
        
        List<CitasResponseDto> lista = citaUseCase.buscarCitasPorVeterinarioyFecha(nombre, fecha)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
                
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscarid/{idCita}")
    public CitasResponseDto buscarPorId(@PathVariable int idCita) {
        return mapper.toResponseDto(citaUseCase.obtenerPorId(idCita));
    }
}
