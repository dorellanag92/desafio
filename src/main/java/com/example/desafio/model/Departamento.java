package com.example.desafio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "departamento_id")
    private Long departamentoId;
    @Column (name = "departamento_nombre")
    private String departamentoNombre;
    @ManyToOne
    @JoinColumn (name = "facultad_id")
    private Facultad facultad;

public Departamento(){
    
}

    public Departamento(Long departamentoId, String departamentoNombre, Facultad facultad) {
        this.departamentoId = departamentoId;
        this.departamentoNombre = departamentoNombre;
        this.facultad = facultad;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
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