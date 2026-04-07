package com.example.PaseoAPP.servicios;

import com.example.PaseoAPP.modelos.Usuario;
import com.example.PaseoAPP.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UsuarioServicio {

    //Inyectando una dependencia al repositorioUsuario
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    public boolean guardarUsuarioEnBD(Usuario datos){
        //validar que datos me envian y si estos cumplen las reglas del negocio
        //Guardar los datos en BD con ayuda del repositorio
        //Validar que el correo a registrar no se haya guardado previamente
        if(repositorioUsuario.findByCorreo(datos.getCorreo()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El correo "+ datos.getCorreo() + " ya existe");
        }
        return false;
    }
    public boolean modificarUsuarioEnBD(Usuario datos, UUID id){
        //validar que datos me envian y si estos cumplen las reglas del negocio
        //Modificar los datos en BD con ayuda del repositorio
        return false;
    }
    public boolean eliminarUsuarioEnBD(UUID id){
        //Buscar y validar si el ID que me envian existe
        //Elimino el registro en BD
        return false;
    }
    public boolean buscarUsuariosEnBD(){
        //**** Dependiendo del parametro de busqueda debo implementar validaciones
        //devuelvo los usuarios o suario que encuentre eb BD
        return false;
    }


}
