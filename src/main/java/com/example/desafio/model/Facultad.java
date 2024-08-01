package com.example.desafio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "facultad")
public class Facultad {
    @Id
    @Column (name = "id")
    private Long id;
    @Column (name = "facultad_nombre")
    private String facultadNombre;

    public Facultad(){
        
    }

    public Facultad(Long id, String facultadNombre) {
        super();
        this.id = id;
        this.facultadNombre = facultadNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultadNombre() {
        return facultadNombre;
    }

    public void setFacultadNombre(String facultadNombre) {
        this.facultadNombre = facultadNombre;
    }


    
}
