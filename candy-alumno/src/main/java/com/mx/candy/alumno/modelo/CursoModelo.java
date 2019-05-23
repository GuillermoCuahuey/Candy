package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.CursoEntidad;
import com.mx.candy.alumno.validacion.NuevoCursoValidacion;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CursoModelo {

    private Integer id;
    private ProgramaModelo programaModelo;
    private Short grado;
    private Character grupo;
    private Date inicio;
    private Date fin;
    private Short beca;
    private List<CobroModelo> cobroModeloLista;

    public CursoModelo() {
    }

    public CursoModelo(Integer id) {
        this.id = id;
    }

    public CursoModelo(CursoEntidad cursoEntidad) {
        this.id = cursoEntidad.getId();
        programaModelo = new ProgramaModelo(cursoEntidad.getProgramaEntidad());
        this.grado = cursoEntidad.getGrado();
        grupo = cursoEntidad.getGrupo();
        inicio = cursoEntidad.getInicio();
        fin = cursoEntidad.getFin();
        beca = cursoEntidad.getBeca();
        if (cursoEntidad.getCursoCobroEntidadLista() != null && !cursoEntidad.getCursoCobroEntidadLista().isEmpty()) {
            cobroModeloLista = cursoEntidad.getCursoCobroEntidadLista().stream().map(CobroModelo::new).collect(Collectors.toList());
        }
    }

    @NotNull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull(groups = {NuevoCursoValidacion.class})
    public ProgramaModelo getProgramaModelo() {
        return programaModelo;
    }

    public void setProgramaModelo(ProgramaModelo programaModelo) {
        this.programaModelo = programaModelo;
    }

    @NotNull(groups = {NuevoCursoValidacion.class})
    @Min(value = 1, groups = {NuevoCursoValidacion.class})
    public Short getGrado() {
        return grado;
    }

    public void setGrado(Short grado) {
        this.grado = grado;
    }

    @NotNull(groups = {NuevoCursoValidacion.class})
    public Character getGrupo() {
        return grupo;
    }

    public void setGrupo(Character grupo) {
        this.grupo = grupo;
    }

    @NotNull(groups = {NuevoCursoValidacion.class})
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    @NotNull(groups = {NuevoCursoValidacion.class})
    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @NotNull(groups = {NuevoCursoValidacion.class})
    @Min( value = 0, groups = {NuevoCursoValidacion.class})
    public Short getBeca() {
        return beca;
    }

    public void setBeca(Short beca) {
        this.beca = beca;
    }

    public List<CobroModelo> getCobroModeloLista() {
        return cobroModeloLista;
    }

    public void setCobroModeloLista(List<CobroModelo> cobroModeloLista) {
        this.cobroModeloLista = cobroModeloLista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoModelo that = (CursoModelo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CursoModelo{");
        sb.append("id=").append(id);
        sb.append(", programaModelo='").append(programaModelo.toString()).append('\'');
        sb.append(", grado=").append(grado);
        sb.append(", grupo=").append(grupo);
        sb.append(", inicio=").append(inicio);
        sb.append(", fin=").append(fin);
        sb.append(", beca=").append(beca);
        sb.append('}');
        return sb.toString();
    }
}
