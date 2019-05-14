package com.mx.candy.entidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno", schema = "finanzas",
        uniqueConstraints = @UniqueConstraint(columnNames = {"curp"}))
public class AlumnoEntidad {

    private String matricula;
    private String curp;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private EstatusEntidad estatusEntidad;
    private ProgramaEntidad programaEntidad;

    @Id
    @Column(name = "matricula")
    @Size(min = 12, max = 12)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Basic
    @Column(name = "curp")
    @NotNull
    @Size(min = 18, max = 18)
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Basic
    @Column(name = "nombre")
    @NotNull
    @Size(min = 3, max = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido_paterno")
    @NotNull
    @Size(min = 3, max = 50)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Basic
    @Column(name = "apellido_materno")
    @NotNull
    @Size(min = 3, max = 50)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @ManyToOne
    @JoinColumn(insertable = false, name = "id_estatus")
    public EstatusEntidad getEstatusEntidad() {
        return estatusEntidad;
    }

    public void setEstatusEntidad(EstatusEntidad estatusEntidad) {
        this.estatusEntidad = estatusEntidad;
    }

    @ManyToOne
    @JoinColumn(name = "id_estatus")
    public ProgramaEntidad getProgramaEntidad() {
        return programaEntidad;
    }

    public void setProgramaEntidad(ProgramaEntidad programaEntidad) {
        this.programaEntidad = programaEntidad;
    }
}
