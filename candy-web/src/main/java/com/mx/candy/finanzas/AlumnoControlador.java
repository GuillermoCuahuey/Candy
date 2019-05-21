package com.mx.candy.finanzas;

import com.mx.candy.alumno.modelo.AlumnoModelo;
import com.mx.candy.alumno.sesion.AlumnoSesionBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class AlumnoControlador {

    private boolean agregarAlumno;
    private AlumnoModelo alumnoModelo;

    @Inject
    private AlumnoSesionBean alumnoSesionBean;

    @PostConstruct
    public void init() {
        alumnoModelo = new AlumnoModelo();
    }

    public void inserta() {
        alumnoSesionBean.inserta(alumnoModelo);
    }

    public AlumnoModelo getAlumnoModelo() {
        return alumnoModelo;
    }

    public void setAlumnoModelo(AlumnoModelo alumnoModelo) {
        this.alumnoModelo = alumnoModelo;
    }

    public boolean isAgregarAlumno() {
        return agregarAlumno;
    }

    public void setAgregarAlumno(boolean agregarAlumno) {
        this.agregarAlumno = agregarAlumno;
    }
}
