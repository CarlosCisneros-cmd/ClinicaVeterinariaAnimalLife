package com.uisrael.apiALconsumo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.uisrael.apiALconsumo.modelo.dto.request.VeterinarioRequestDto;
import com.uisrael.apiALconsumo.modelo.dto.response.VeterinarioResponseDto;
import com.uisrael.apiALconsumo.servicio.IVeterinarioServicio;

@Controller
@RequestMapping("/Veterinario")
public class VeterinarioControlador {
	
	@Autowired
	private IVeterinarioServicio servicioVeterinario;
	
	@GetMapping("/Nuevo")
	public String formulario(Model model) {
	    model.addAttribute("veterinario", new VeterinarioRequestDto());
	    return "Veterinario/Guardarveterinario";
	}
	
    @GetMapping("/Listarveterinario")
  	public String Listarveterinario(Model model) {
  		List<VeterinarioResponseDto> datosBase = servicioVeterinario.listarVeterinario();
  		model.addAttribute("listarveterinario", datosBase);
  		return "Veterinario/Listarveterinario";
  	}

  	@PostMapping("/Guardar")
  	public String Guardarveterinario(@ModelAttribute VeterinarioRequestDto veterinario) {
  		servicioVeterinario.crearVeterinario(veterinario);
  		return "redirect:/Veterinario/Listarveterinario";
  	}
  	
  	@GetMapping("/Eliminar/{id}")
	public String eliminarVeterinario(@PathVariable int id) {
		servicioVeterinario.eliminarVeterinario(id);
		return "redirect:/Veterinario/Listarveterinario";
	}
  	
  	 @GetMapping("/buscar/{idVeterinario}")
     public String editarVeterinario(@PathVariable int idVeterinario, Model model) {
     	model.addAttribute("veterinario",servicioVeterinario.buscarPorId(idVeterinario));
 		return "Veterinario/Guardarveterinario";
     }
}
