package com.example.PaseoAPP.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaseoAPP.modelos.Reserva;

public interface IRepositorioReserva extends JpaRepository<Reserva, UUID>{
}
