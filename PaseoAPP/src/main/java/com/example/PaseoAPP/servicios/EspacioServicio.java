package com.example.PaseoAPP.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaseoAPP.modelos.Espacio;
import com.example.PaseoAPP.repositorios.IRepositorioEspacio;

@Service
public class EspacioServicio {
    @Autowired
    private IRepositorioEspacio repositorioEspacio;

    public Espacio guardarEspacio(Espacio datos){
        return this.repositorioEspacio.save(datos);
    }
}
