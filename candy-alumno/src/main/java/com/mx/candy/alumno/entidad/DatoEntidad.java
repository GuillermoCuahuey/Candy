package com.mx.candy.alumno.entidad;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dato", schema = "alumno")
@NamedQuery(name = "DatoEntidad.busca", query = "SELECT d FROM DatoEntidad d")
public class DatoEntidad {

    private String idAlumno;
    private AlumnoEntidad alumnoEntidad;
    private String alergias;
    private String observaciones;

    public DatoEntidad() {
    }

    public DatoEntidad(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public DatoEntidad(String alergias, String observaciones) {
        this.alergias = alergias;
        this.observaciones = observaciones;
    }

    @Id
    @Column(name = "id_alumno")
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public AlumnoEntidad getAlumnoEntidad() {
        return alumnoEntidad;
    }

    public void setAlumnoEntidad(AlumnoEntidad alumnoEntidad) {
        this.alumnoEntidad = alumnoEntidad;
    }

    @Basic
    @Column(name = "alergias")
    @Size(max = 50)
    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    @Basic
    @Column(name = "observaciones")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
