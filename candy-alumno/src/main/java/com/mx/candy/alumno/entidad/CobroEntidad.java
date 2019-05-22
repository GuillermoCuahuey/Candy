package com.mx.candy.alumno.entidad;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cobro", schema = "alumno")
public class CobroEntidad extends CatalogoEntidad {

    private Float monto;

    @Basic
    @Column(name = "monto")
    @NotNull
    @Min(0)
    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }
}
