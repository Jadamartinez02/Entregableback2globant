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

        //condiciones logicas para validar datos a guardar

        //1. validar que el correo a registrar no se haya guardado previamente
        if(repositorioUsuario.findByCorreo(datos.getCorreo()).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un correo <<<<regisitrado>>>> igual al que me entregas"
            );
        }

        if(datos.getNombres().isEmpty()||datos.getNombres().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre digitado no puede enviarse vacio"
            );
        }

        if(datos.getContraseña().length()<6){
            throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST,
              "La contarseña debe tener al menos 6 caracteres"
            );

        }

        //Si paso la zona de validaciones procedo a preparar la
        // receta(Ejecuto la query que se necesite)
        this.repositorioUsuario.save(datos);

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
