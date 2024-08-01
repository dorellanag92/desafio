package com.example.desafio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "departamento")
public class Departamento {
    @Id
    @Column (name = "id")
    private Long id;
    @Column (name = "departamento_nombre")
    private String departamentoNombre;
    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

    public Departamento(){
        
    }
    
    public Departamento(Long id, String departamentoNombre, Facultad facultad) {
        this.id = id;
        this.departamentoNombre = departamentoNombre;
        this.facultad = facultad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

}