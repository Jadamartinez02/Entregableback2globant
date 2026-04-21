package com.example.PaseoAPP.controlador;

import com.example.PaseoAPP.modelos.Reserva;
import com.example.PaseoAPP.modelos.Usuario;
import com.example.PaseoAPP.servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/paseoapi/v1/reserva")
public class ReservaControlador {
    @Autowired
    private ReservaServicio reservaServicio;
    @PostMapping
    public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva datos){
        return ResponseEntity.status(HttpStatus.CREATED).body(datos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> modificarReserva(@RequestBody Reserva datos,@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(reservaServicio.modificarReserva(datos, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable UUID id){
        reservaServicio.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<List<Reserva>> buscarUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(reservaServicio.buscarReserva());
    }
}
