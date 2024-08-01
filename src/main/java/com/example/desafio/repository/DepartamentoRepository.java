package com.example.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    //Para obtener la lista de departamentos segun la id de la facultad
    List<Departamento> findByFacultadId(Long facultadId);
}
