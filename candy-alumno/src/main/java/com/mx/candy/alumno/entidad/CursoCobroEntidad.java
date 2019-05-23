package com.mx.candy.alumno.entidad;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "curso_cobro", schema = "alumno")
public class CursoCobroEntidad {

    private CursoCobroEntidadPK cursoCobroEntidadPK;
    private CursoEntidad cursoEntidad;
    private CobroEntidad cobroEntidad;
    private Float monto;

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
    @MapsId("idCurso")
    @JoinColumn(name = "id_curso")
    public CursoEntidad getCursoEntidad() {
        return cursoEntidad;
    }

    public void setCursoEntidad(CursoEntidad cursoEntidad) {
        this.cursoEntidad = cursoEntidad;
    }

    @ManyToOne
    @MapsId("idCobro")
    @JoinColumn(name = "id_cobro")
    public CobroEntidad getCobroEntidad() {
        return cobroEntidad;
    }

    public void setCobroEntidad(CobroEntidad cobroEntidad) {
        this.cobroEntidad = cobroEntidad;
    }

    @Basic
    @Column(name = "monto")
    @NotNull
    @Digits(integer = 10, fraction = 2)
    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }
}
