package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.CursoEntidad;
import com.mx.candy.alumno.entidad.ProgramaEntidad;
import com.mx.candy.alumno.modelo.CursoModelo;
import com.mx.candy.alumno.validacion.NuevoCursoValidacion;
import com.mx.candy.nucleo.herramienta.ValidadorSessionBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class CursoSesionBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    @Inject
    private ValidadorSessionBean validadorSessionBean;

    public List<CursoModelo> busca() {
        return entityManager.createNamedQuery("CursoEntidad.busca", CursoEntidad.class).getResultList()
                .stream().map(CursoModelo::new).collect(Collectors.toList());
    }

    public void inserta(@NotNull CursoModelo cursoModelo) {
        validadorSessionBean.validacion(cursoModelo, NuevoCursoValidacion.class);
        logger.fine(cursoModelo.toString());
        CursoEntidad cursoEntidad = new CursoEntidad();
        cursoEntidad.setProgramaEntidad(new ProgramaEntidad(cursoModelo.getProgramaModelo().getClave()));
        cursoEntidad.setGrado(cursoModelo.getGrado());
        cursoEntidad.setGrupo(cursoModelo.getGrupo());
        cursoEntidad.setInicio(cursoModelo.getInicio());
        cursoEntidad.setFin(cursoModelo.getFin());
        entityManager.persist(cursoEntidad);
        logger.finer("Llave generada:".concat(cursoEntidad.getId().toString()));
        cursoModelo.setId(cursoEntidad.getId());
    }
}
