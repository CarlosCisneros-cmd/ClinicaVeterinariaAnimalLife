package com.uisrael.apiALconsumo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.apiALconsumo.modelo.dto.request.ServicioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.ServicioResponseDto;
import com.uisrael.apiALconsumo.servicio.IServicioServicio;

@Controller
@RequestMapping("/servicio")
public class ServicioControlador {
	
	
	@Autowired
    private IServicioServicio servicioService;
	
	@GetMapping({"/", ""}) 
    public String inicioServicio() {
        return "redirect:/servicio/listar"; 
    }

	@GetMapping("/nuevo") 
    public String formularioNuevo(Model model) {
        model.addAttribute("servicio", new ServicioRequestDto());
        return "Servicio/Guardarservicio"; 
    }
    
    @GetMapping("/listar")
    public String listarServicios(Model model) {
        List<ServicioResponseDto> datosBase = servicioService.listarServicio();
        model.addAttribute("listarservicio", datosBase);
        return "Servicio/Listarservicio";
    }

    @PostMapping("/guardar")
    public String guardarServicio(@ModelAttribute ServicioRequestDto servicio) {
        servicioService.crearServicio(servicio);
        return "redirect:/servicio/listar";
    }
}
