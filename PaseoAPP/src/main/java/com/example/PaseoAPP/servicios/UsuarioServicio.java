package com.example.PaseoAPP.servicios;

import com.example.PaseoAPP.modelos.Usuario;
import com.example.PaseoAPP.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
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
        if(datos.getNombres().isEmpty()||datos.getNombres().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,"El nombre digitado no puede enviarse vacio"
            );
        }
        if (datos.getContraseña().length()<6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La contrasela debe tener al menos 6 caracteres");
        }
        this.repositorioUsuario.save(datos);
        return false;
    }
    public Usuario modificarUsuarioEnBD(Usuario datos, UUID id){
        Optional<Usuario> usuarioBuscado =this.repositorioUsuario.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario que quieres editar no existe en base de datos");
        }
        Usuario usuarioENcontrado = usuarioBuscado.get();
        if (datos.getNombres().isEmpty() || datos.getNombres().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La contrasela debe tener al menos 6 caracteres");
        }
        usuarioENcontrado.setNombres(datos.getNombres());
        return this.repositorioUsuario.save(usuarioENcontrado);

    }
    public boolean eliminarUsuarioEnBD(UUID id){
        //Buscar y validar si el ID que me envian existe
        //Elimino el registro en BD
        return false;
    }
    public List<Usuario> buscarUsuariosEnBD(){
        //**** Dependiendo del parametro de busqueda debo implementar validaciones
        //devuelvo los usuarios o suario que encuentre eb BD
        List<Usuario> usuariosENcontrados = this.repositorioUsuario.findAll();
        return usuariosENcontrados;
    }


}
