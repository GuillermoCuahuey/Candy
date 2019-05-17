package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.EstatusEntidad;
import com.mx.candy.nucleo.modelo.CatalogoModelo;

public class EstatusModelo extends CatalogoModelo {

    public EstatusModelo() {
    }

    public EstatusModelo(Short clave) {
        super(clave);
    }

    public EstatusModelo(Short clave, String descripcion) {
        super(clave, descripcion);
    }

    public EstatusModelo(EstatusEntidad estatusEntidad) {
        super(estatusEntidad);
    }
}
