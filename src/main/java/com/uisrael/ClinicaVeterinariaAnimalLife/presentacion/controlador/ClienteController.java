package com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IClienteUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.mapeador.IClienteDtoMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.request.ClienteRequestDto;
import com.uisrael.ClinicaVeterinariaAnimalLife.presentacion.dto.response.ClienteResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final IClienteUseCase clienteUseCase;
    private final IClienteDtoMapper mapper;

    public ClienteController(IClienteUseCase clienteUseCase, IClienteDtoMapper mapper) {
        this.clienteUseCase = clienteUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody ClienteRequestDto request) {
        try {
            ClienteResponseDto response = mapper.toResponseDto(
                clienteUseCase.crear(mapper.toDomain(request))
            );
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage()); 
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping
    public List<ClienteResponseDto> listar() {
        return clienteUseCase.listar().stream().map(mapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        clienteUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("buscarid/{idCliente}")
    public ClienteResponseDto buscarPorId(@PathVariable int idCliente) {
        return mapper.toResponseDto(clienteUseCase.obtenerPorId(idCliente));
    }



    @GetMapping("/inactivos")
    public List<ClienteResponseDto> listarInactivos() {
        return clienteUseCase.listarInactivos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PutMapping("/recuperar/{id}")
    public ResponseEntity<Void> recuperar(@PathVariable int id) {
        clienteUseCase.recuperar(id);
        return ResponseEntity.noContent().build();
    }
}
	
		
