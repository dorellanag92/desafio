package com.example.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.Facultad;
import com.example.desafio.service.FacultadService;

@RestController
@RequestMapping("/facultades")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping
    private List<Facultad> getAllFacultades(){
        return facultadService.findAll();
    }
}
