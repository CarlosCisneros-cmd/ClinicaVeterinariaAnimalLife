package com.uisrael.apiALconsumo.controlador;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.uisrael.apiALconsumo.modelo.dto.request.CabeceraRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.CabeceraResponseDto;
import com.uisrael.apiALconsumo.modelo.dto.response.PacienteResponseDTO;
import com.uisrael.apiALconsumo.servicio.ICabeceraServicio;

@Controller
@RequestMapping("/Cabecera")
public class CabeceraControlador {
	
	@Autowired
	private ICabeceraServicio servicioCabecera;
	
	@GetMapping("/Mostrar")
    public String Mostrarcabecera(@RequestParam int idPaciente,@RequestParam String nombrePac,@RequestParam String nombreCli, Model model) {
        model.addAttribute("idPaciente", idPaciente);
        model.addAttribute("nombrePac", nombrePac);
        model.addAttribute("nombreCli", nombreCli);
        List<CabeceraResponseDto> todas = servicioCabecera.Listarcabecera();
        List<CabeceraResponseDto> filtradas = todas.stream()
            .filter(c -> c.getFkPaciente() != null && c.getFkPaciente().getIdPaciente() == idPaciente)
            .collect(Collectors.toList());   
        model.addAttribute("listarcabeceras", filtradas);
        return "Cabecera/Mostrarcabecera";
    }
	

	@GetMapping("/Crearcabecera")
	public String Crearcabecera(@RequestParam int idPaciente, @RequestParam String nombrePac, @RequestParam String nombreCli) {
	    CabeceraRequestDto nueva = new CabeceraRequestDto();
	    nueva.setNombreCabecera(nombrePac);
	    nueva.setNombreCliente(nombreCli);
	    nueva.setFechaCreacion(LocalDateTime.now());
	    PacienteResponseDTO pacienteTemp = new PacienteResponseDTO();
	    pacienteTemp.setIdPaciente(idPaciente); 
	    nueva.setFkPaciente(pacienteTemp); 
	    servicioCabecera.crearCabecera(nueva);
	    return "redirect:/Cabecera/Mostrar?idPaciente=" + idPaciente + 
	           "&nombrePac=" + nombrePac + 
	           "&nombreCli=" + nombreCli;
	}
}


