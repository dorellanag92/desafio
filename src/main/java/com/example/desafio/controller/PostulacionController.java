package com.example.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping ("/postulaciones") //Se especifica la URL
public class PostulacionController{

    @Autowired
    private PostulacionService postulacionService;

    //Manejo de solicitudes HTTP GET para obtener la lista de postulaciones
    @GetMapping
    private List<Postulacion> getAllPostulaciones(){
        return postulacionService.findAll();
    }

    //Igual que el anterior pero con un codigo de postulacion especifico
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Postulacion>> getPostulacionById(@PathVariable Long id){
        return ResponseEntity.ok(postulacionService.findById(id));
    }

    //Manejo de solicitudes HTTP POST para crear una postulacion
    @PostMapping
    private Postulacion savePostulacion(@RequestBody Postulacion postulacion){
        return postulacionService.save(postulacion);
    }

    //Manejo de solicitudes HTTP PUT para actualizar una postulacion existente mediante su codigo, 
    @PutMapping("/{id}")
    public ResponseEntity<Postulacion> updatePostulacion(@PathVariable Long id, @RequestBody Postulacion postulacion){
        Optional<Postulacion> existingPostulacion = postulacionService.findById(id);
        //Se hace uso de un if-else para verificar la existencia de la postulacion
        if (existingPostulacion.isPresent()) {
            Postulacion updatedPostulacion = existingPostulacion.get();
            updatedPostulacion.setRut(postulacion.getRut());
            updatedPostulacion.setTituloPostulacion(postulacion.getTituloPostulacion());
            updatedPostulacion.setDepartamento(postulacion.getDepartamento());
            updatedPostulacion.setCorreo(postulacion.getCorreo());
            updatedPostulacion.setFecha(postulacion.getFecha());
            postulacionService.save(updatedPostulacion);
            return ResponseEntity.ok(updatedPostulacion);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //Manejo de solicitudes HTTP DELETE para eliminar una postulacion existente mediante su codigo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostulacion(@PathVariable Long id){
        if (postulacionService.findById(id).isPresent()) {
            postulacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}