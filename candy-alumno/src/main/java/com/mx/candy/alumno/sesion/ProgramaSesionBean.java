package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.ProgramaEntidad;
import com.mx.candy.alumno.modelo.ProgramaModelo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Servicios para los programas de un curso
 * @author Antonio Francisco Alonso Valerdi
 * @Since 0.1
 */
@Stateless
public class ProgramaSesionBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    /**
     * Busca todos los programas
     * @return Coleción de {@link ProgramaModelo}
     */
    public List<ProgramaModelo> busca() {
        return entityManager.createNamedQuery("ProgramaEntidad.busca", ProgramaEntidad.class)
                .getResultList().stream().map(ProgramaModelo::new).collect(Collectors.toList());
    }

    /**
     * Busca un programa
     * @param id Identificador
     * @return Objecto con los d atos
     */
    public ProgramaModelo busca(Short id) {
        logger.fine(id.toString());
        return new ProgramaModelo(entityManager.find(ProgramaEntidad.class, id));
    }

    /**
     * Actualiza los datos de un programa.
     * @param programaModelo Datos a ser actualizados.
     * @return Número de elementos modificados.
     */
    public int actualiza(ProgramaModelo programaModelo) {
        logger.fine(programaModelo.toString());
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<ProgramaEntidad> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(ProgramaEntidad.class);
        Root<ProgramaEntidad> root = criteriaUpdate.from(ProgramaEntidad.class);
        Path<String> path = root.get("descripcion");
        Predicate predicate = criteriaBuilder.equal(root.get("clave"), programaModelo.getClave());
        criteriaUpdate.set(path, programaModelo.getDescripcion()).where(predicate);
        return entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    /**
     * Crea un nuevo programa
     * @param descripcion Datos del nuevo programa
     */
    public void inserta(@NotNull @Size(min = 3, max = 30) String descripcion) {
        ProgramaEntidad programaEntidad = new ProgramaEntidad();
        programaEntidad.setDescripcion(descripcion);
        entityManager.persist(programaEntidad);
    }

}
