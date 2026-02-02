package com.uisrael.apiALconsumo.controlador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginControlador {

    // MOSTRAR LOGIN
    @GetMapping
    public String mostrarLogin() {
        return "Login/login"; // templates/Login/Login.html
    }

    // PROCESAR LOGIN
    @PostMapping
    public String procesarLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session) {

        // VALIDACIÓN (temporal)
        if ("admin".equals(username) && "1234".equals(password)) {
            session.setAttribute("usuario", username);
            return "redirect:/PaginaPrincipal";
        }

        model.addAttribute("error", true);
        return "Login/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
