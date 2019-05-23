package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.CobroEntidad;
import com.mx.candy.alumno.entidad.CursoCobroEntidad;
import com.mx.candy.nucleo.modelo.CatalogoModelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

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

    public CobroModelo(CursoCobroEntidad cursoCobroEntidad) {
        this(cursoCobroEntidad.getCobroEntidad());
        monto = cursoCobroEntidad.getMonto();
    }

    @NotNull
    @Min(0)
    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CobroModelo.class.getSimpleName() + "[", "]")
                .add("monto=" + monto)
                .add(super.toString())
                .toString();
    }
}
