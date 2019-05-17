package com.mx.candy.alumno.entidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacto", schema = "alumno")
@NamedQuery(name = "ContactoEntidad.busca", query = "SELECT c FROM ContactoEntidad c")
public class ContactoEntidad {

    private String telefono;
    private String nombre;

    @Id
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "nombre")
    @NotNull
    @Size(min = 3, max = 150)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
