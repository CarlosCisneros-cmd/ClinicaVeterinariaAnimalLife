package com.uisrael.apiALconsumo.servicio.Impl;

import org.springframework.stereotype.Service;

import com.uisrael.apiALconsumo.servicio.IUsuarioServicio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    @Override
    public boolean login(String username, String password) {
        return "admin".equals(username) && "1234".equals(password);
    }
}
