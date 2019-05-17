package com.mx.candy.nucleo.modelo;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import java.util.Objects;

public class CatalogoModelo {

    private Short clave;
    private String descripcion;

    public CatalogoModelo() {
    }

    public CatalogoModelo(Short clave) {
        this.clave = clave;
    }

    public CatalogoModelo(Short clave, String descripcion) {
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public CatalogoModelo(CatalogoEntidad catalogoEntidad) {
        clave = catalogoEntidad.getClave();
        descripcion = catalogoEntidad.getDescripcion();
    }

    public Short getClave() {
        return clave;
    }

    public void setClave(Short clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogoModelo that = (CatalogoModelo) o;
        return clave.equals(that.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogoModelo{");
        sb.append("clave=").append(clave);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
