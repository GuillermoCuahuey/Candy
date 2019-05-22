package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.AlumnoEntidad;
import com.mx.candy.alumno.entidad.CursoEntidad;
import com.mx.candy.alumno.entidad.ProgramaEntidad;
import com.mx.candy.alumno.modelo.AlumnoModelo;
import com.mx.candy.alumno.modelo.CursoModelo;
import com.mx.candy.alumno.validacion.NuevoCursoValidacion;
import com.mx.candy.nucleo.herramienta.ValidadorSessionBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import javax.validation.constraints.Min;
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

    public List<AlumnoModelo> buscaAlumnos(@NotNull Integer id) {
        return entityManager.createNamedQuery("CursoEntidad.buscaAlumnos", AlumnoEntidad.class)
                .getResultList().stream().map(AlumnoModelo::new).collect(Collectors.toList());
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
        cursoEntidad.setBeca(cursoModelo.getBeca());
        entityManager.persist(cursoEntidad);
        logger.finer("Llave generada:".concat(cursoEntidad.getId().toString()));
        cursoModelo.setId(cursoEntidad.getId());
    }

    public void elimina(@NotNull Integer id) {
        logger.fine(id.toString());
        entityManager.remove(entityManager.find(CursoEntidad.class, id));
    }

    public int actualiza(@NotNull @Valid CursoModelo cursoModelo) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<CursoEntidad> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(CursoEntidad.class);
        Root<CursoEntidad> root = criteriaUpdate.from(CursoEntidad.class);
        criteriaUpdate
                .set("grado", cursoModelo.getGrado())
                .set("grupo", cursoModelo.getGrupo())
                .set("inicio", cursoModelo.getInicio())
                .set("fin", cursoModelo.getFin())
                .set("beca", cursoModelo.getBeca())
                .set("programaEntidad", cursoModelo.getProgramaModelo().getClave())
                .where(criteriaBuilder.equal(root.get("id"),cursoModelo.getId()));
        return entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

}
