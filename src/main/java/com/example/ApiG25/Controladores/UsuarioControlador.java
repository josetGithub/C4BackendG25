package com.example.ApiG25.Controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.ApiG25.Modelos.UsuarioModelo;


import com.example.ApiG25.Servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioControlador {
    
    @Autowired
    UsuarioServicio servicio;
    
    @PostMapping("/guardar")
    public UsuarioModelo guardarUsuario(@RequestBody UsuarioModelo usuario) {
        return servicio.guardarUsuario(usuario);

    }
// htpp://localhost:8080/usuario/consultar

@GetMapping("/consultar")
public ArrayList<UsuarioModelo> consultarUsuario(){
    return servicio.consultarUsuarios();
}

//http:localhost:8080/usuario/consultardocumento

@GetMapping("/consultardocumento/{documento}") 
public Optional <UsuarioModelo> consultaDocumento(@PathVariable("documento") Long documento) {
    return servicio.buscarPorDocumento(documento);

}

//http://localhost:8080/usuario/eliminar           eliminar un usurio 
@DeleteMapping("/eliminar/{documento}")
public Boolean eliminar(@PathVariable("documento") Long documento){
    return servicio.eliminaUsuario(documento);
}

//http://localhost:8080/usuario/buscarxapellido

@GetMapping("/buscarxapellido/{apellido}")
public ArrayList<UsuarioModelo> buscarxapellido(@PathVariable("apellido") String apellido) {
    return servicio.buscarxapellido(apellido);
}

//http://localhost:8080/usuario/buscarxnombre
@GetMapping("/buscarxnombre/{nombre}")
public ArrayList<UsuarioModelo> buscarxnombre(@PathVariable("nombre") String nombre) {
    return servicio.buscarxnombre(nombre);
}

}
