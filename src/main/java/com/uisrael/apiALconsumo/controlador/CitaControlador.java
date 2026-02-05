package com.uisrael.apiALconsumo.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.apiALconsumo.modelo.dto.request.CitasRequestDto;

import com.uisrael.apiALconsumo.modelo.dto.response.CitasResponseDto; 
import com.uisrael.apiALconsumo.modelo.dto.response.PacienteResponseDTO;
import com.uisrael.apiALconsumo.servicio.ICitasServicio;
import com.uisrael.apiALconsumo.servicio.IPacienteServicio;
import com.uisrael.apiALconsumo.servicio.IServicioServicio;
import com.uisrael.apiALconsumo.servicio.IVeterinarioServicio;

@Controller
@RequestMapping("/Cita")
public class CitaControlador {
    
    @Autowired
    private ICitasServicio citaServicio;
    @Autowired
    private IPacienteServicio pacienteServicio;
    @Autowired
    private IVeterinarioServicio veterinarioServicio;
    @Autowired
    private IServicioServicio servicioCatalogo;

    @GetMapping("/Nuevo")
    public String formularioNuevoCita(@RequestParam(required = false) Integer idPaciente, Model model) {
    	CitasRequestDto cita = new CitasRequestDto();
        
       
        cita.setFkVeterinario(new com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto());
        cita.setFkPaciente(new com.uisrael.apiALconsumo.modelo.dto.request.PacienteRequestDTO());
     
        cita.setServicios(new java.util.ArrayList<>()); 

        if (idPaciente != null) {
            PacienteResponseDTO paciente = pacienteServicio.obtenerPorId(idPaciente);
        
            cita.getFkPaciente().setIdPaciente(idPaciente);
            
            model.addAttribute("nombreMascota", paciente.getNombre());
            model.addAttribute("nombreDuenio", paciente.getFkCliente().getNombres() + " " + paciente.getFkCliente().getApellidos());
        }

        
        model.addAttribute("cita", cita);
        model.addAttribute("listaVeterinarios", veterinarioServicio.listarVeterinario());
        model.addAttribute("listaServicios", servicioCatalogo.listarServicio());
        
        return "Citas/Guardarcita";
        
        
    }

    @PostMapping("/Guardar")
    public String guardarCita(@ModelAttribute CitasRequestDto cita) {
    	
  
        if (cita.getFkVeterinario() == null) {
            cita.setFkVeterinario(new com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto());
        }

        citaServicio.crearCita(cita);
        return "redirect:/Cita/Listarcita";
    }
    
   
    @GetMapping("/Listarcita")
    public String listarcita(@RequestParam(required = false) String fechaFiltro, Model model) {
    
        List<CitasResponseDto> lista = citaServicio.listarCitas();
        
   
        if (fechaFiltro != null && !fechaFiltro.isEmpty()) {
            lista = lista.stream()
                .filter(c -> c.getFecha_Hora() != null && 
                        c.getFecha_Hora().toLocalDate().toString().equals(fechaFiltro))
                .collect(Collectors.toList());
            
         
            model.addAttribute("fechaSeleccionada", fechaFiltro);
        }
        
        model.addAttribute("listacitas", lista);
        model.addAttribute("listaVeterinarios", veterinarioServicio.listarVeterinario());
        return "Citas/Listarcita";
    }
    
    @GetMapping("/Eliminar/{id}")
    public String eliminarCita(@PathVariable int id) {
        citaServicio.eliminarCita(id);
        return "redirect:/Cita/Listarcita";
    }
    
    @GetMapping("/buscar/{idCita}")
    public String editarCita(@PathVariable int idCita, Model model) {
    	model.addAttribute("cita",citaServicio.buscarPorId(idCita));
		return "Citas/Guardarcita";
    }
}