package com.mx.candy.nucleo.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class CatalogoEntidad {

    private Short clave;
    private String descripcion;

    public CatalogoEntidad() {
    }

    public CatalogoEntidad(Short clave) {
        this.clave = clave;
    }

    public CatalogoEntidad(Short clave, String descripcion) {
        this.clave = clave;
        this.descripcion = descripcion;
    }

    @Id
    @Column(name = "clave")
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