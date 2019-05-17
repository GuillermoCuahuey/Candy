package com.mx.candy.alumno.entidad;


import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "estatus", schema = "alumno")
@NamedQuery(name = "EstatusEntidad.busca", query = "SELECT e FROM EstatusEntidad e")
public class EstatusEntidad extends CatalogoEntidad {

    public EstatusEntidad() {
    }

    public EstatusEntidad(Short clave) {
        super(clave);
    }
}
