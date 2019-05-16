package com.mx.candy.alumno;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "alumno", schema = "alumno",
        uniqueConstraints = @UniqueConstraint(columnNames = {"curp"}))
@NamedQueries( value = {
        @NamedQuery(name = "AlumnoEntidad.busca", query = "SELECT a FROM AlumnoEntidad a LEFT JOIN FETCH a.estatusEntidad e")
})
public class AlumnoEntidad {

    private String matricula;
    private String curp;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private EstatusEntidad estatusEntidad;
    private String direccion;
    private String celular;
    private String telefono;
    private String rfc;
    private Date nacimiento;

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

    @Basic
    @Column(name = "direccion")
    @NotNull
    @Size(min = 3, max = 200)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "celular")
    @NotNull
    @Size(min = 10, max = 10)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Basic
    @Column(name = "telefono")
    @NotNull
    @Size(min = 10, max = 10)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "rfc")
    @NotNull
    @Size(min = 12, max = 13)
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Basic
    @Column(name = "nacimiento")
    @NotNull
    @Temporal(value = TemporalType.DATE)
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
}
