package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.ICabeceraUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.ICitaUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IClienteUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IDetallesUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IPacienteUseCase;


import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IServicioUseCase;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl.CabeceraUseCaseImpl;


import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl.CitasUseCaseImpl;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.entrada.IVeterinarioUseCase;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl.ClienteUseCaseImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl.DetallesUseCaseImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl.PacienteUseCaseImpl;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl.ServicioUseCaseImpl;

import com.uisrael.ClinicaVeterinariaAnimalLife.aplicacion.casodeuso.impl.VeterinarioUseCaseImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.ICabeceraRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.ICitasRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IClientesRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IDetallesRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IPacienteRepositorio;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IServicioRepositorio;

import com.uisrael.ClinicaVeterinariaAnimalLife.domino.repositorio.IVeterinarioRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores.CabeceraRepositorioImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores.CitasRepositorioImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores.ClientesRespositorioImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores.DetallesRepositorioImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores.PacienteRepositorioImpl;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores.ServicioRepositorioImpl;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.adaptadores.VeterinarioRepositorioImpl;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.ICabeceraJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.ICitasJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IDetallesJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IPacienteJpaMapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IServicioJpaMapper;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.mapeadores.IVeterinarioJpaMapper;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.ICabecerJpaRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.ICitasJpaRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IClientesJpaRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IDetallesJpaRepositorio;
import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IPacienteJpaRepositorio;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IServicioJpaRepositorio;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa.IVeterinarioJpaRepositorio;



@Configuration
public class ConfiguracionGeneral {


    @Bean
    IClientesRepositorio clienteRepositorio(IClientesJpaRepositorio jpaRepository, IClienteJpaMapper mapper) {
        return new ClientesRespositorioImpl(jpaRepository, mapper);
    }
    @Bean
    IClienteUseCase clienteUseCase(IClientesRepositorio repositorio) {
        return new ClienteUseCaseImpl(repositorio);
    }
    
    
    @Bean
    ICitasRepositorio citaRepositoeio(ICitasJpaRepositorio jpaRepository, ICitasJpaMapper mapper) {
        return new CitasRepositorioImpl(jpaRepository, mapper);
    }
    @Bean
    ICitaUseCase citaUseCase(ICitasRepositorio repositorio) {
        return new CitasUseCaseImpl(repositorio);
    }
    
    @Bean
    IVeterinarioRepositorio veterinarioRepositorio(IVeterinarioJpaRepositorio jpaRepository, IVeterinarioJpaMapper mapper) {
    	return new VeterinarioRepositorioImpl(jpaRepository, mapper);
    }
    @Bean

    IVeterinarioUseCase veterinarioUseCase(IVeterinarioRepositorio repositorio) {
    	return new VeterinarioUseCaseImpl(repositorio);
    }

    @Bean
    IPacienteRepositorio pacienteRepositorio(IPacienteJpaRepositorio jpaRepository, IPacienteJpaMapper mapper) {
        return new PacienteRepositorioImpl(jpaRepository, mapper);
    }
    @Bean
    IPacienteUseCase pacienteUseCase(IPacienteRepositorio repositorio) {
        return new PacienteUseCaseImpl(repositorio);
    }

    
    @Bean
    ICabeceraRepositorio cabeceraRepositorio(ICabecerJpaRepositorio jpaRepository,ICabeceraJpaMapper mapper) {
    	return new CabeceraRepositorioImpl(jpaRepository, mapper);
    }
    @Bean
    ICabeceraUseCase cabeceraUseCase(ICabeceraRepositorio repositorio) {
    	return new CabeceraUseCaseImpl(repositorio);

    }

    @Bean
    IServicioRepositorio servicioRepositorio(IServicioJpaRepositorio jpaRepository, IServicioJpaMapper mapper) {
        return new ServicioRepositorioImpl(jpaRepository, mapper);
    }
    @Bean
    IServicioUseCase serivicioUseCase(IServicioRepositorio repositorio) {
        return new ServicioUseCaseImpl(repositorio);
    }

    @Bean
    IDetallesRepositorio detallesRepositorio(IDetallesJpaRepositorio jpaRepository, IDetallesJpaMapper mapper) {
        return new DetallesRepositorioImpl(jpaRepository, mapper);
    }
    @Bean
    IDetallesUseCase detallesUseCase(IDetallesRepositorio repositorio) {
        return new DetallesUseCaseImpl(repositorio);
    }

}

