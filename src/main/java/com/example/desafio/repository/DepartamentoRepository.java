package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
