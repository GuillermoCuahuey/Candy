package com.mx.candy.alumno.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CursoCobroEntidadPK implements Serializable {

    private Short idCobro;
    private Integer idCurso;

    public CursoCobroEntidadPK() {
    }

    public CursoCobroEntidadPK(Short idCobro, Integer idCurso) {
        this.idCobro = idCobro;
        this.idCurso = idCurso;
    }

    @Basic
    @Column(name = "id_cobro")
    public Short getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(Short idCobro) {
        this.idCobro = idCobro;
    }

    @Basic
    @Column(name = "id_curso")
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoCobroEntidadPK that = (CursoCobroEntidadPK) o;
        return idCobro.equals(that.idCobro) &&
                idCurso.equals(that.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCobro, idCurso);
    }
}
