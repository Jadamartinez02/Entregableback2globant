package com.example.PaseoAPP.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.PaseoAPP.modelos.Usuario;
import com.example.PaseoAPP.servicios.UsuarioServicio;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/paseoapi/v1/usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @PostMapping
    public ResponseEntity<Usuario> guaridarUsuarioEnDb(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicio.guardarUsuarioEnBD(datos));  
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable UUID id){
        usuarioServicio.eliminarUsuarioEnBD(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> buscarUsuarioEnDB(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.buscarUsuariosEnBD());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario datos, @PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.modificarUsuarioEnBD(datos, id));
    }
}
