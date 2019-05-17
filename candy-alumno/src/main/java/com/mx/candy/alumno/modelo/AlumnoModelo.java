package com.mx.candy.alumno.modelo;

import com.mx.candy.alumno.entidad.AlumnoEntidad;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class AlumnoModelo extends AlumnoBaseModelo {

    private String curp;
    private String estatus;
    private String direccion;
    private String celular;
    private String telefono;
    private String correoElectronico;
    private String rfc;
    private Date nacimiento;
    private String alergias;
    private String observaciones;

    public AlumnoModelo() {
    }

    public AlumnoModelo(String matricula) {
        super(matricula);
    }

    public AlumnoModelo(AlumnoEntidad alumnoEntidad) {
        curp = alumnoEntidad.getCurp();
        estatus = alumnoEntidad.getEstatusEntidad().getDescripcion();
        direccion = alumnoEntidad.getDireccion();
        celular = alumnoEntidad.getCelular();
        telefono = alumnoEntidad.getTelefono();
        correoElectronico = alumnoEntidad.getCorreoElectronico();
        rfc = alumnoEntidad.getRfc();
        nacimiento = alumnoEntidad.getNacimiento();
        alergias = alumnoEntidad.getDatoEntidad().getAlergias();
        observaciones = alumnoEntidad.getDatoEntidad().getObservaciones();
    }

    @NotNull
    @Size(min = 18, max = 18)
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @NotNull
    @Size(min = 3, max = 200)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @NotNull
    @Size(min = 10, max = 10)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @NotNull
    @Size(min = 10, max = 10)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @NotNull
    @Size(min = 3, max = 150)
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @NotNull
    @Size(min = 12, max = 13)
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @NotNull
    @Past
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Size(max = 50)
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
