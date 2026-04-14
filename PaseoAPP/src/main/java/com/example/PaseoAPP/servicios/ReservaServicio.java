package com.example.PaseoAPP.servicios;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoAPP.modelos.Reserva;
import com.example.PaseoAPP.repositorios.IRepositorioReserva;

@Service
public class ReservaServicio {
    private IRepositorioReserva repositorioReserva;

    public Reserva guardarReserva(Reserva datos){
        if (datos.getFecha() == LocalDate.now()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La reserva no ouede ser el mismo dia ");
        }
        return this.repositorioReserva.save(datos);
    }
    public Reserva modificarReserva(Reserva datos, UUID id){
        Optional<Reserva> datoBuscado = this.repositorioReserva.findById(id);
        Reserva datoEncontrado = datoBuscado.get();
        datoEncontrado.setFecha(datos.getFecha());;
        return this.repositorioReserva.save(datos);
    }
}
