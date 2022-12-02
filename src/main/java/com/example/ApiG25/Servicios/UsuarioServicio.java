package com.example.ApiG25.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiG25.Modelos.UsuarioModelo;
import com.example.ApiG25.Repositorios.UsuarioRepositorio;

@Service

public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio repositorio;

    public UsuarioModelo guardarUsuario(UsuarioModelo usuario) {
        return repositorio.save(usuario);
        
    }

    public ArrayList<UsuarioModelo>consultarUsuarios() {
        return (ArrayList<UsuarioModelo>) repositorio.findAll();
    }

public Optional<UsuarioModelo> buscarPorDocumento(Long documento) {
    return repositorio.findById(documento);

}

public Boolean eliminaUsuario(long documento) {
    if (repositorio.existsById(documento)) {
        repositorio.deleteById(documento);
        return true;
    }else {
        return false;
    }
}

//buscar por apellidos
public ArrayList<UsuarioModelo>  buscarxapellido(String apellido) {
    return repositorio.findByApellido(apellido);
}


//buscar por nombre

public ArrayList<UsuarioModelo>  buscarxnombre(String nombre) {
    return repositorio.findByNombre(nombre);
}

}
