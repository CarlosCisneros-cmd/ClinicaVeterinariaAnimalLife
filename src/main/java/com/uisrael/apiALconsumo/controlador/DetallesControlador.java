package com.uisrael.apiALconsumo.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.apiALconsumo.modelo.dto.request.CabeceraRequestDto;

import com.uisrael.apiALconsumo.modelo.dto.request.DetallesRequestDto;

import com.uisrael.apiALconsumo.modelo.dto.response.DetallesResponseDto;

import com.uisrael.apiALconsumo.servicio.IDetallesServicio;

@Controller
@RequestMapping("/detalles")
public class DetallesControlador {
	
	@Autowired
    private IDetallesServicio detallesService;

    @GetMapping("/listar")
    public String listarDetalles(@RequestParam int idCabecera, Model model) {
    	model.addAttribute("idCabecera", idCabecera);
		List<DetallesResponseDto> todosDetalles = detallesService.listarDetalles();
		List<DetallesResponseDto> filtradas = todosDetalles.stream()
			.filter(p -> p.getFkCabecera() != null && p.getFkCabecera().getIdCabecera() == idCabecera)
			.collect(Collectors.toList());
		model.addAttribute("listardetalles", filtradas);
        return "Detalles/Listardetalles";
    }

    @GetMapping("/nuevo") 
    public String formularioNuevo(@RequestParam int idCabecera, Model model) {
    	DetallesRequestDto nuevo = new DetallesRequestDto();
        nuevo.setFkCabecera(new CabeceraRequestDto());
        nuevo.getFkCabecera().setIdCabecera(idCabecera);
        model.addAttribute("detalle", nuevo);
        model.addAttribute("idCabecera", idCabecera);
        return "Detalles/Guardardetalles";
       
    }

    
    @PostMapping("/guardar")
    public String guardarDetalle(DetallesRequestDto detalle, @RequestParam int idCabecera) {
    	if(detalle.getFkCabecera() == null) {
            detalle.setFkCabecera(new CabeceraRequestDto());
        }
        detalle.getFkCabecera().setIdCabecera(idCabecera);
        
        detallesService.crearDetalles(detalle);
        
        return "redirect:/detalles/listar?idCabecera=" + idCabecera;
    }
    
    

}
