package com.mx.candy.alumno.entidad;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "programa", schema = "alumno")
@NamedQuery(name = "ProgramaEntidad.busca", query = "SELECT p FROM ProgramaEntidad p")
@SequenceGenerator(name = "secuencia", schema = "alumno", sequenceName = "programa_seq")
public class ProgramaEntidad {

    private Short clave;
    private String descripcion;

    public ProgramaEntidad() {
    }

    public ProgramaEntidad(Short clave) {
        this.clave = clave;
    }

    @Id
    @Column(name = "clave")
    @GeneratedValue(generator = "secuencia")
    public Short getClave() {
        return clave;
    }

    public void setClave(Short clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "descripcion")
    @NotNull
    @Size(min = 3, max = 30)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
