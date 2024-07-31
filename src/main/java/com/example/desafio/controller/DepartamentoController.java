package com.example.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.Departamento;
import com.example.desafio.service.DepartamentoService;

@RestController
@RequestMapping ("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/{id}")
    private List<Departamento> getAllDepartamentoByFacultad(@PathVariable("id") Long idFacultad){
        return departamentoService.findAllByFacultad(idFacultad);
    }
}
