package com.example.desafio.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "postulacion")
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String rut;
    @Column (name="titulo_postulacion")
    private String tituloPostulacion;
    @ManyToOne
    @JoinColumn (name="departamento_id")
    private Departamento departamento;
    private String correo;
    private LocalDate fecha;

    public Postulacion(){

    }
    
    public Postulacion(String rut, String tituloPostulacion, Departamento departamento, String correo, LocalDate fecha) {
        super();
        this.rut = rut;
        this.tituloPostulacion = tituloPostulacion;
        this.departamento = departamento;
        this.correo = correo;
        this.fecha = fecha;
    }

    public Long getCodigo() {
        return codigo;
    }
    public String getRut() {
        return rut;
    }
    public String getTituloPostulacion() {
        return tituloPostulacion;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public String getCorreo() {
        return correo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setTituloPostulacion(String tituloPostulacion) {
        this.tituloPostulacion = tituloPostulacion;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}