package com.example.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.Facultad;
import com.example.desafio.service.FacultadService;

@RestController
@RequestMapping("/api/facultades")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping
    private List<Facultad> getAllFacultades(){
        return facultadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Facultad>> getFacultadById(@PathVariable Long id){
        Optional<Facultad> facultad = facultadService.findById(id);
        return ResponseEntity.ok(facultad);
    }
}
