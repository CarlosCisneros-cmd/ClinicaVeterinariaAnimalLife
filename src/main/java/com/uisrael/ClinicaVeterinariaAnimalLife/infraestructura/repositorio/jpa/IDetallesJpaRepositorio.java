package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.repositorio.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.persistencia.jpa.DetallesJpa;

public interface IDetallesJpaRepositorio extends JpaRepository<DetallesJpa, Integer>{

}
