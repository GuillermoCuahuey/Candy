package com.mx.candy.alumno.entidad;

import javax.persistence.*;

@Entity
@Table(name = "curso_cobro", schema = "alumno")
public class CursoCobroEntidad {

    private CursoCobroEntidadPK cursoCobroEntidadPK;
    private CursoEntidad cursoEntidad;
    private CobroEntidad cobroEntidad;

    public CursoCobroEntidad() {
    }

    public CursoCobroEntidad(CursoCobroEntidadPK cursoCobroEntidadPK) {
        this.cursoCobroEntidadPK = cursoCobroEntidadPK;
    }

    @EmbeddedId
    public CursoCobroEntidadPK getCursoCobroEntidadPK() {
        return cursoCobroEntidadPK;
    }

    public void setCursoCobroEntidadPK(CursoCobroEntidadPK cursoCobroEntidadPK) {
        this.cursoCobroEntidadPK = cursoCobroEntidadPK;
    }

    @ManyToOne
    @MapsId("idCobro")
    public CursoEntidad getCursoEntidad() {
        return cursoEntidad;
    }

    public void setCursoEntidad(CursoEntidad cursoEntidad) {
        this.cursoEntidad = cursoEntidad;
    }

    @ManyToOne
    @MapsId("idCurso")
    public CobroEntidad getCobroEntidad() {
        return cobroEntidad;
    }

    public void setCobroEntidad(CobroEntidad cobroEntidad) {
        this.cobroEntidad = cobroEntidad;
    }
}
