package com.example.PaseoAPP.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoAPP.modelos.Espacio;
import com.example.PaseoAPP.repositorios.IRepositorioEspacio;

@Service
public class EspacioServicio {
    @Autowired
    private IRepositorioEspacio repositorioEspacio;

    public Espacio guardarEspacio(Espacio datos){
        if (datos.getAforo() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aforo no encontrados");
        }
        if (datos.getAforo()>15) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aforo sobrepasa el limite");
        }
        return this.repositorioEspacio.save(datos);
    }
        public Espacio modificarEspacio(Espacio datos, UUID id){
        Optional<Espacio> datoBuscado = this.repositorioEspacio.findById(id);
        Espacio datoEncontrado = datoBuscado.get();
        datoEncontrado.setNombre(datos.getNombre());
        return this.repositorioEspacio.save(datos);
    }
        public void eliminarEspacio(UUID id){
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
        }
        this.repositorioEspacio.deleteById(id);
    }
        public List<Espacio> buscarEspacio(){
        return this.repositorioEspacio.findAll();
    }
}
