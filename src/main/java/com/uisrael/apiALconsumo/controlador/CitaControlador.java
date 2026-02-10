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
import com.uisrael.apiALconsumo.modelo.dto.request.PacienteRequestDTO;
import com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto;
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
    public String guardarCita(@ModelAttribute CitasRequestDto cita, Model model) {
        try {
            if (cita.getFkVeterinario() == null) {
                cita.setFkVeterinario(new com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto());
            }

            citaServicio.crearCita(cita);
            return "redirect:/Cita/Listarcita";

        } catch (RuntimeException e) {
            
            model.addAttribute("error", e.getMessage());
            model.addAttribute("cita", cita);
            
           
            model.addAttribute("listaVeterinarios", veterinarioServicio.listarVeterinario());
            model.addAttribute("listaServicios", servicioCatalogo.listarServicio());

            
            if (cita.getFkPaciente() != null && cita.getFkPaciente().getIdPaciente() > 0) {
                try {
                    PacienteResponseDTO paciente = pacienteServicio.obtenerPorId(cita.getFkPaciente().getIdPaciente());
                    model.addAttribute("nombreMascota", paciente.getNombre());
                    model.addAttribute("nombreDuenio", paciente.getFkCliente().getNombres() + " " + paciente.getFkCliente().getApellidos());
                } catch (Exception ex) {
                   
                }
            }
            
            return "Citas/Guardarcita";
        }
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
        CitasResponseDto response = citaServicio.buscarPorId(idCita);
        CitasRequestDto citaReq = new CitasRequestDto();
        citaReq.setIdCita(response.getIdCita());
        citaReq.setFecha_Hora(response.getFecha_Hora());
        
        if (response.getFkVeterinario() != null) {
            VeterinarioRequestDto v = new VeterinarioRequestDto();
            v.setIdveterinario(response.getFkVeterinario().getIdveterinario());
            citaReq.setFkVeterinario(v);
        }
        if (response.getFkPaciente() != null) {
            PacienteRequestDTO p = new PacienteRequestDTO();
            p.setIdPaciente(response.getFkPaciente().getIdPaciente());
            citaReq.setFkPaciente(p);
            model.addAttribute("nombreMascota", response.getFkPaciente().getNombre());
            if(response.getFkPaciente().getFkCliente() != null) {
                model.addAttribute("nombreDuenio", response.getFkPaciente().getFkCliente().getNombres() + " " + response.getFkPaciente().getFkCliente().getApellidos());
            }
        }
        if (response.getServicios() != null) {
            List<Integer> serviciosIds = response.getServicios().stream()
                    .map(s -> s.getIdservicio())
                    .collect(Collectors.toList());
            citaReq.setServicios(serviciosIds);
        }
        
        model.addAttribute("cita", citaReq);
        model.addAttribute("listaVeterinarios", veterinarioServicio.listarVeterinario());
        model.addAttribute("listaServicios", servicioCatalogo.listarServicio());
        
        return "Citas/Guardarcita";
    }
}