package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Postulacion;

// Se crea el repositorio mediante una interfaz para la interaccion con la base de datos, se realiza lo mismo para Departamento y Facultad
public interface PostulacionRepository extends JpaRepository<Postulacion, Long>{

}
