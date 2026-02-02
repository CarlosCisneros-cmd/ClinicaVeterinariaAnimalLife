package com.uisrael.apiALconsumo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.apiALconsumo.modelo.dto.request.DetallesRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.DetallesResponseDto;
import com.uisrael.apiALconsumo.servicio.IDetallesServicio;

@Controller
@RequestMapping("/detalles")
public class DetallesControlador {
	
	@Autowired
    private IDetallesServicio detallesService;

    @GetMapping({"/", ""}) 
    public String inicioDetalles() {
        return "redirect:/detalles/listar"; 
    }

    @GetMapping("/listar")
    public String listarDetalles(Model model) {
        List<DetallesResponseDto> lista = detallesService.listarDetalles();
        model.addAttribute("listardetalles", lista);
        return "Detalles/Listardetalles";
    }

    @GetMapping("/nuevo") 
    public String formularioNuevo(Model model) {
        model.addAttribute("detalle", new DetallesRequestDto());
        return "Detalles/Guardardetalles"; 
    }

    
    @PostMapping("/guardar")
    public String guardarDetalle(@ModelAttribute DetallesRequestDto detalle) {
        detallesService.crearDetalles(detalle);
        return "redirect:/detalles/listar";
    }

}
