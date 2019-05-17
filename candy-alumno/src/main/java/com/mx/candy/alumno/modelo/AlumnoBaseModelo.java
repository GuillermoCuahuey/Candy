package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.AlumnoEntidad;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class AlumnoBaseModelo {

    private String matricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public AlumnoBaseModelo() {
    }

    public AlumnoBaseModelo(String matricula) {
        this.matricula = matricula;
    }

    public AlumnoBaseModelo(AlumnoEntidad alumnoEntidad) {
        matricula = alumnoEntidad.getMatricula();
        nombre = alumnoEntidad.getNombre();
        apellidoPaterno = alumnoEntidad.getApellidoPaterno();
        apellidoMaterno = alumnoEntidad.getApellidoMaterno();
    }

    @NotNull
    @Size(min = 12, max = 12)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @NotNull
    @Size(min = 3, max = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @NotNull
    @Size(min = 3, max = 50)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @NotNull
    @Size(min = 3, max = 50)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoBaseModelo that = (AlumnoBaseModelo) o;
        return matricula.equals(that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlumnoBaseModelo{");
        sb.append("matricula='").append(matricula).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellidoPaterno='").append(apellidoPaterno).append('\'');
        sb.append(", apellidoMaterno='").append(apellidoMaterno).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
