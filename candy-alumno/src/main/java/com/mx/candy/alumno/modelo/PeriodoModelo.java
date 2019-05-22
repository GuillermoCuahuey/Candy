package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.PeriodoEntidad;
import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import com.mx.candy.nucleo.modelo.CatalogoModelo;

public class PeriodoModelo extends CatalogoModelo {
    public PeriodoModelo() {
    }

    public PeriodoModelo(Short clave) {
        super(clave);
    }

    public PeriodoModelo(PeriodoEntidad catalogoEntidad) {
        super(catalogoEntidad);
    }
}
