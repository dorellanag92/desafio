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

// Se crea la clase con sus respectivos atributos, posteriormente se realiza lo mismo para Facultad y Departamento

@Entity //se especifica la clase como una entidad
@Table (name = "postulacion") //
public class Postulacion {
    // se establece el atributo como un Id y que sea autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String rut;
    @Column (name="titulo_postulacion") //se especifica el nombre de la columna en postgres
    private String tituloPostulacion;
    @ManyToOne //se especifica la relación
    @JoinColumn(name = "facultad_id") //se especifica a que columna esta relacionado el atributo
    private Facultad facultad;
    @ManyToOne
    @JoinColumn (name = "departamento_id")
    private Departamento departamento;
    private String correo;
    private LocalDate fecha;

    //Constructores generados automaticamente
    
    public Postulacion() {
    }

    public Postulacion(String rut, String tituloPostulacion, Facultad facultad, Departamento departamento,
        String correo, LocalDate fecha) {
        super();
        this.rut = rut;
        this.tituloPostulacion = tituloPostulacion;
        this.facultad = facultad;
        this.departamento = departamento;
        this.correo = correo;
        this.fecha = fecha;
    }

    //Getters y Setters generados automaticamente
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTituloPostulacion() {
        return tituloPostulacion;
    }

    public void setTituloPostulacion(String tituloPostulacion) {
        this.tituloPostulacion = tituloPostulacion;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}