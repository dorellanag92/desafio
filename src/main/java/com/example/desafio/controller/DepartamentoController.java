package com.example.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.Departamento;
import com.example.desafio.service.DepartamentoService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/facultad/{facultadId}")
    public List<Departamento> getDepartamentosByFacultadId(@PathVariable Long facultadId) {
        return departamentoService.findByFacultadId(facultadId);
    }
    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Departamento>> getDepartamentoById(@PathVariable Long id){
        Optional<Departamento> departamento = departamentoService.findById(id);
        return ResponseEntity.ok(departamento);
    }
    
}
