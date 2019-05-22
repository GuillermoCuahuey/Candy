package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.CobroEntidad;
import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import com.mx.candy.nucleo.modelo.CatalogoModelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CobroModelo extends CatalogoModelo {

    private Float monto;

    public CobroModelo() {
    }

    public CobroModelo(Short clave) {
        super(clave);
    }

    public CobroModelo(CobroEntidad cobroEntidad) {
        super(cobroEntidad);
        monto = cobroEntidad.getMonto();
    }

    @NotNull
    @Min(0)
    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }
}
