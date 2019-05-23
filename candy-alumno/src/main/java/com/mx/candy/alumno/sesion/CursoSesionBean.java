package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.*;
import com.mx.candy.alumno.modelo.CobroModelo;
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
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Los cursos que pertenece a los alumnos.
 * @author Antonio Francisco Alonso Valerdi
 * @since 0.1
 */
@Stateless
public class CursoSesionBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    @Inject
    private ValidadorSessionBean validadorSessionBean;

    /**
     * Busca todos los cursos.
     * @return Coleción de {@link CursoModelo}.
     */
    public List<CursoModelo> busca() {
        return entityManager.createNamedQuery("CursoEntidad.busca", CursoEntidad.class).getResultList()
                .stream().map(CursoModelo::new).collect(Collectors.toList());
    }

    /**
     * Busca un curso por identificador, incluye una coleción de {@link CobroModelo} con los montos por curso.
     * @param id Identificador del curso.
     * @return Datos localizados en un objecto del tipo {@link CursoModelo}.
     */
    public CursoModelo buscaCobro(@NotNull Integer id) {
        logger.fine(id.toString());
        return new CursoModelo(entityManager.createNamedQuery("CursoEntidad.buscaCobros", CursoEntidad.class)
                .setParameter("id", id).getSingleResult());
    }

    /**
     * Crea un nuevo Curso, la lleve generada de dicho curso se encuentra lcoalizada en el campo id de {@link CursoModelo}.
     * @param cursoModelo Datos del curso a ser creado.
     */
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

    /**
     * Elimina un curso.
     * @param id Identtificador del curso.
     */
    public void elimina(@NotNull Integer id) {
        logger.fine(id.toString());
        entityManager.remove(entityManager.find(CursoEntidad.class, id));
    }

    /**
     * Actualiza un curso.
     * @param cursoModelo Datos del curso a ser actualizado.
     * @return
     */
    public int actualiza(@NotNull @Valid CursoModelo cursoModelo) {
        logger.fine(cursoModelo.toString());
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
