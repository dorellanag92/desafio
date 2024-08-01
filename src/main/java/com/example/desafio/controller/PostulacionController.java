package com.example.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.Postulacion;
import com.example.desafio.service.PostulacionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Se crea el controlador REST para las postulaciones, posteriormente se realiza para Facultad y Departamento
@RestController //se especifica la clase como un controlador REST
@RequestMapping ("/api/postulaciones") //Se especifica la URL
public class PostulacionController{

    @Autowired
    private PostulacionService postulacionService;

    //Manejo de solicitudes HTTP GET para obtener la lista de postulaciones
    @GetMapping
    private List<Postulacion> getAllPostulaciones(){
        return postulacionService.findAll();
    }

    //Igual que el anterior pero con un codigo de postulacion especifico
    @GetMapping("/{codigo}")
    public ResponseEntity<Postulacion> getPostulacionById(@PathVariable Long codigo){
        Postulacion postulacion = postulacionService.getPostulacionById(codigo);
        return ResponseEntity.ok(postulacion);
    }

    //Manejo de solicitudes HTTP POST para crear una postulacion
    @PostMapping
    public ResponseEntity<Postulacion> createPostulacion(@RequestBody Postulacion postulacion) {
        Postulacion createdPostulacion = postulacionService.createPostulacion(postulacion);
        return new ResponseEntity<>(createdPostulacion, HttpStatus.CREATED);
    }

    //Manejo de solicitudes HTTP PUT para actualizar una postulacion existente mediante su codigo, 
    @PutMapping("/{codigo}")
    public ResponseEntity<Postulacion> updatePostulacion(@PathVariable Long codigo, @RequestBody Postulacion postulacionDetails) {
        Postulacion updatedPostulacion = postulacionService.updatePostulacion(codigo, postulacionDetails);
        return ResponseEntity.ok(updatedPostulacion);
    }

    //Manejo de solicitudes HTTP DELETE para eliminar una postulacion existente mediante su codigo
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletePostulacion(@PathVariable Long codigo) {
        postulacionService.deletePostulacion(codigo);
        return ResponseEntity.noContent().build();
    }
}