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
	
	public ClienteController (IClienteUseCase clienteUseCase, IClienteDtoMapper mapper) {
	this.clienteUseCase = clienteUseCase;
	this.mapper = mapper;

}
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto crear(@Valid @RequestBody ClienteRequestDto request) {

        return mapper.toResponseDto(clienteUseCase.crear(mapper.toDomain(request)));
    }
	@GetMapping
	public List<ClienteResponseDto> listar(){
		
	return clienteUseCase.listar().stream().map(mapper::toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable int id){
		clienteUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("buscarid/{idCliente}")
	public ClienteResponseDto buscarPorId(@PathVariable int idCliente) {
		return mapper.toResponseDto(clienteUseCase.obtenerPorId(idCliente));
		
	}
}
	
		
