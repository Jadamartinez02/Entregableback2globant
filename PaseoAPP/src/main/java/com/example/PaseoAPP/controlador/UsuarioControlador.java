package com.example.PaseoAPP.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaseoAPP.modelos.Usuario;
import com.example.PaseoAPP.servicios.UsuarioServicio;

@RestController
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @PostMapping
    public ResponseEntity<Usuario> guaridarUsuarioEnDb(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicio.guardarUsuarioEnBD(datos));  
    }
}
