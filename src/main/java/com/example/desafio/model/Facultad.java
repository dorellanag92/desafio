package com.example.desafio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "facultad")
public class Facultad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "facultad_id")
    private Long facultadId;
    @Column (name = "facultad_nombre")
    private String facultadNombre;

    public Facultad(){
        
    }

    public Facultad(Long facultadId, String facultadNombre) {
        super();
        this.facultadId = facultadId;
        this.facultadNombre = facultadNombre;
    }

    public Long getFacultadId() {
        return facultadId;
    }

    public String getFacultadNombre() {
        return facultadNombre;
    }

    public void setFacultadId(Long facultadId) {
        this.facultadId = facultadId;
    }

    public void setFacultadNombre(String facultadNombre) {
        this.facultadNombre = facultadNombre;
    }

    
}
