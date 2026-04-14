package com.example.PaseoAPP.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaseoAPP.modelos.Espacio;

public interface IRepositorioEspacio extends JpaRepository<Espacio, UUID> {
}
