package com.uisrael.apiALconsumo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cita")
public class CitaControlador {
	
	@GetMapping
    public String Guardarcita() {
        return "Citas/Guardarcita";
    }
    
    @GetMapping("/Listarcita")
    public String Listarcita() {
        return "Citas/Listarcita";
    }
}
