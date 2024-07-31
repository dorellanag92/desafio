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


@RestController
@RequestMapping ("/postulaciones")
public class PostulacionController{

    @Autowired
    private PostulacionService postulacionService;

    @GetMapping
    private List<Postulacion> getAllPostulaciones(){
        return postulacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Postulacion>> getPostulacionById(@PathVariable Long id){
        return ResponseEntity.ok(postulacionService.findById(id));
    }

    @PostMapping
    private Postulacion savePostulacion(@RequestBody Postulacion postulacion){
        return postulacionService.save(postulacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postulacion> updatePostulacion(@PathVariable Long id, @RequestBody Postulacion postulacion){
        Optional<Postulacion> existingPostulacion = postulacionService.findById(id);

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