package com.example.PaseoAPP.modelos;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Espacio {
    //id, nombre, descripcion, aforo, foto
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    private String descripcion;
    private Long aforo;
    private String foto;
    public Espacio() {
    }
    public Espacio(UUID id, String nombre, String descripcion, Long afoto, String foto, Long aforo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aforo = aforo;
        this.foto = foto;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public Long getAforo() {
        return aforo;
    }
    public void setAforo(Long aforo) {
        this.aforo = aforo;
    }

}
