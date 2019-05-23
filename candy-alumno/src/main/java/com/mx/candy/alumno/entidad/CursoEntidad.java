package com.mx.candy.alumno.entidad;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "curso", schema = "alumno")
@SequenceGenerator(name = "secuencia", schema = "alumno", sequenceName = "curso_sec")
@NamedQueries(value = {
        @NamedQuery(
                name = "CursoEntidad.busca",
                query = "SELECT c FROM CursoEntidad c LEFT JOIN FETCH c.programaEntidad"),
        @NamedQuery(
                name = "CursoEntidad.buscaCobros",
                query = "SELECT c FROM CursoEntidad c LEFT JOIN FETCH c.cursoCobroEntidadLista ccel " +
                        "LEFT JOIN FETCH ccel.cobroEntidad co WHERE c.id = :id")
})
public class CursoEntidad {

    private Integer id;
    private ProgramaEntidad programaEntidad;
    private Short grado;
    private Character grupo;
    private Date inicio;
    private Date fin;
    private Short beca;
    private List<CursoCobroEntidad> cursoCobroEntidadLista;

    public CursoEntidad() {
    }

    public CursoEntidad(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "secuencia")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa")
    public ProgramaEntidad getProgramaEntidad() {
        return programaEntidad;
    }

    public void setProgramaEntidad(ProgramaEntidad programaEntidad) {
        this.programaEntidad = programaEntidad;
    }

    @Basic
    @Column(name = "grado")
    @NotNull
    @Min(1)
    public Short getGrado() {
        return grado;
    }

    public void setGrado(Short grado) {
        this.grado = grado;
    }

    @Basic
    @Column(name = "grupo")
    @NotNull
    public Character getGrupo() {
        return grupo;
    }

    public void setGrupo(Character grupo) {
        this.grupo = grupo;
    }

    @Basic
    @Column(name = "inicio")
    @NotNull
    @Temporal(value = TemporalType.DATE)
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    @Basic
    @Column(name = "fin")
    @NotNull
    @Temporal(value = TemporalType.DATE)
    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Basic
    @Column(name = "beca")
    @NotNull
    @Min(0)
    public Short getBeca() {
        return beca;
    }

    public void setBeca(Short beca) {
        this.beca = beca;
    }

    @OneToMany(
            mappedBy = "cursoEntidad",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    public List<CursoCobroEntidad> getCursoCobroEntidadLista() {
        return cursoCobroEntidadLista;
    }

    public void setCursoCobroEntidadLista(List<CursoCobroEntidad> cursoCobroEntidadLista) {
        this.cursoCobroEntidadLista = cursoCobroEntidadLista;
    }

}
