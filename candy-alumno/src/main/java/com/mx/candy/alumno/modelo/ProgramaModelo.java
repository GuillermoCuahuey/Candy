package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.ProgramaEntidad;
import com.mx.candy.nucleo.modelo.CatalogoModelo;

public class ProgramaModelo extends CatalogoModelo {

    public ProgramaModelo() {
    }

    public ProgramaModelo(Short clave) {
        super(clave);
    }

    public ProgramaModelo(ProgramaEntidad programaEntidad) {
        super(programaEntidad.getClave(), programaEntidad.getDescripcion());
    }
}
