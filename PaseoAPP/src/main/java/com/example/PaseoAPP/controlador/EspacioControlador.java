package com.example.PaseoAPP.controlador;

import com.example.PaseoAPP.modelos.Espacio;
import com.example.PaseoAPP.servicios.EspacioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/paseoapi/v1/espacio")
public class EspacioControlador {
    @Autowired
    private EspacioServicio espacioServicio;
    @PostMapping
    public ResponseEntity<Espacio> guardarEspacio(@RequestBody Espacio datos){
        return ResponseEntity.status(HttpStatus.CREATED).body(espacioServicio.guardarEspacio(datos));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Espacio> actualizarEspacio(@RequestBody Espacio datos, @PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(espacioServicio.modificarEspacio(datos, id));
    }
    @GetMapping
    public ResponseEntity<List<Espacio>> buscarEspacios(){
        return ResponseEntity.status(HttpStatus.OK).body(espacioServicio.buscarEspacio());
    }
    public ResponseEntity<Void> eliminarEspacio(@PathVariable UUID id){
        espacioServicio.eliminarEspacio(id);
        return ResponseEntity.noContent().build();
    }
}
