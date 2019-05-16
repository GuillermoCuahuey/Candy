package com.mx.candy.alumno;

import javax.persistence.*;

@Entity
@Table(name = "dato", schema = "alumno")
public class DatoEntidad {

    private String idAlumno;
    private AlumnoEntidad alumnoEntidad;
    private String alergias;
    private String observaciones;

    @Id
    @Column(name = "id_alumno")
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public AlumnoEntidad getAlumnoEntidad() {
        return alumnoEntidad;
    }

    public void setAlumnoEntidad(AlumnoEntidad alumnoEntidad) {
        this.alumnoEntidad = alumnoEntidad;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
