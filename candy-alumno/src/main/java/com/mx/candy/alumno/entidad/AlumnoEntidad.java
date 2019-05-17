package com.mx.candy.alumno.entidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "alumno", schema = "alumno",
        uniqueConstraints = @UniqueConstraint(columnNames = {"curp"}))
@Access(AccessType.PROPERTY)
@NamedQueries( value = {
        @NamedQuery(
                name = "AlumnoEntidad.busca",
                query = "SELECT a FROM AlumnoEntidad a LEFT JOIN FETCH a.estatusEntidad e LEFT JOIN FETCH a.datoEntidad d"),
        @NamedQuery(
                name = "AlumnoEntidad.elimina",
                query = "DELETE FROM AlumnoEntidad a WHERE a.matricula = :matricula")
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
    private String correoElectronico;
    private String rfc;
    private Date nacimiento;
    private DatoEntidad datoEntidad;

    public AlumnoEntidad() {
    }

    public AlumnoEntidad(String matricula, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

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

    @ManyToOne(cascade = {CascadeType.REMOVE})
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
    @Column(name = "correo_electronico")
    @NotNull
    @Size(min = 3, max = 150)
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
    @Past
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @OneToOne(mappedBy = "alumnoEntidad", cascade = CascadeType.ALL)
    public DatoEntidad getDatoEntidad() {
        return datoEntidad;
    }

    public void setDatoEntidad(DatoEntidad datoEntidad) {
        this.datoEntidad = datoEntidad;
    }
}
