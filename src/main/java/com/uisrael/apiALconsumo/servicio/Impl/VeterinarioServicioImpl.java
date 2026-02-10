package com.uisrael.apiALconsumo.servicio.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.VeterinarioResponseDto;
import com.uisrael.apiALconsumo.servicio.IVeterinarioServicio;

import reactor.core.publisher.Mono;

@Service
public class VeterinarioServicioImpl implements IVeterinarioServicio {

	private final WebClient webcliente;

	public VeterinarioServicioImpl(WebClient webcliente) {
		this.webcliente = webcliente;
	}

	@Override
	public void crearVeterinario(VeterinarioRequestDto dto) {
		webcliente.post()
			.uri("/veterinarios")
			.bodyValue(dto)
			.retrieve()
			.onStatus(status -> status.is4xxClientError(), response -> 
				response.bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
					.flatMap(errorBody -> {
						String mensaje = "Error en los datos del veterinario";
						
						if (errorBody.containsKey("cedula")) {
							mensaje = errorBody.get("cedula").toString();
						} else if (errorBody.containsKey("correo")) {
							mensaje = errorBody.get("correo").toString();
						} else if (errorBody.containsKey("mensaje")) {
							mensaje = errorBody.get("mensaje").toString();
						}
						
						return Mono.<Throwable>error(new RuntimeException(mensaje));
					})
			)
			.toBodilessEntity()
			.block();
	}

	@Override
	public List<VeterinarioResponseDto> listarVeterinario() {
		return webcliente.get()
				.uri("/veterinarios")
				.retrieve()
				.bodyToFlux(VeterinarioResponseDto.class)
				.collectList()
				.block();
	}

	@Override
	public void eliminarVeterinario(int id) {
		webcliente.delete()
				.uri("/veterinarios/{id}", id)
				.retrieve()
				.toBodilessEntity()
				.block();
	}

	@Override
	public VeterinarioResponseDto buscarPorId(int idVeterinario) {
		return webcliente.get()
				.uri(uriBuilder -> uriBuilder.path("/veterinarios/buscarid/{idVeterinario}")
				.build(idVeterinario))
				.retrieve()
				.bodyToMono(VeterinarioResponseDto.class)
				.block();
	}
}


