package com.mx.candy.alumno.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "curso_cobro", schema = "alumno")
public class CursoCobroEntidad {

    @EmbeddedId
    private CursoCobroEntidadPK cursoCobroEntidadPK;


}
