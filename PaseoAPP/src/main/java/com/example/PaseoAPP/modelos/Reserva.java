package com.example.PaseoAPP.modelos;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Reserva {
    //id, fecha y tiempo
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate fecha;
    private Integer tiempo;
    public Reserva() {
    }
    public Reserva(UUID id, LocalDate fecha, Integer tiempo) {
        this.id = id;
        this.fecha = fecha;
        this.tiempo = tiempo;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Integer getTiempo() {
        return tiempo;
    }
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }
    
}
