package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.AlumnoEntidad;
import com.mx.candy.alumno.entidad.DatoEntidad;
import com.mx.candy.alumno.modelo.AlumnoModelo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Elemento para la administración de un alumno
 */
@Stateless
public class AlumnoSesionBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    /**
     * Busca todos los alumnos registrados
     * @return Colección de {@link AlumnoModelo}
     */
    public List<AlumnoModelo> busca() {
        return entityManager.createNamedQuery("AlumnoEntidad.busca", AlumnoEntidad.class)
                .getResultList().stream().map(AlumnoModelo::new)
                .collect(Collectors.toList());
    }

    /**
     * Busca a un alumno por su matrícula.
     * @param matricula alumno a ser buscado.
     * @return Objeto del tipo {@link AlumnoModelo} con los datos.
     */
    public AlumnoModelo busca(@NotNull @Size(min = 12, max = 12) String matricula) {
        return new AlumnoModelo(entityManager.find(AlumnoEntidad.class, matricula));
    }

    /**
     * Almacena un {@link AlumnoModelo}, el objecto no de ser nulo y debe tener validos sus campos
     * @param alumnoModelo
     */
    public void inserta(@NotNull @Valid AlumnoModelo alumnoModelo) {
        logger.fine(alumnoModelo.toString());
        AlumnoEntidad alumnoEntidad = new AlumnoEntidad();
        alumnoEntidad.setNombre(alumnoModelo.getNombre());
        alumnoEntidad.setApellidoPaterno(alumnoModelo.getApellidoPaterno());
        alumnoEntidad.setApellidoMaterno(alumnoModelo.getApellidoMaterno());
        alumnoEntidad.setMatricula(alumnoModelo.getMatricula());
        alumnoEntidad.setCurp(alumnoModelo.getCurp());
        alumnoEntidad.setDireccion(alumnoModelo.getDireccion());
        alumnoEntidad.setCelular(alumnoModelo.getCelular());
        alumnoEntidad.setTelefono(alumnoModelo.getTelefono());
        alumnoEntidad.setRfc(alumnoModelo.getRfc());
        alumnoEntidad.setCorreoElectronico(alumnoModelo.getCorreoElectronico());
        alumnoEntidad.setNacimiento(alumnoModelo.getNacimiento());
        entityManager.persist(alumnoEntidad);
        if ((alumnoModelo.getAlergias() != null && !alumnoModelo.getAlergias().isEmpty())
                || (alumnoModelo.getObservaciones() != null && !alumnoModelo.getObservaciones().isEmpty())) {
            DatoEntidad datoEntidad = new DatoEntidad(alumnoModelo.getMatricula());
            datoEntidad.setAlergias(alumnoModelo.getAlergias());
            datoEntidad.setObservaciones(alumnoModelo.getObservaciones());
            entityManager.persist(datoEntidad);
        }
    }

    /**
     * Elimina un alumno
     * @param matricula Matrícula del alumno a eliminar
     * @return número de elementos modificados
     */
    public int elimina(@NotNull @Size(min = 12, max = 12) String matricula) {
        logger.fine(matricula);
        return entityManager.createNamedQuery("AlumnoEntidad.elimina").setParameter("matricula", matricula).executeUpdate();
    }

    public int actualiza(@NotNull @Valid AlumnoModelo alumnoModelo) {
        int modificados = 0;
        logger.fine(alumnoModelo.toString());
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<AlumnoEntidad> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(AlumnoEntidad.class);
        Root<AlumnoEntidad> root = criteriaUpdate.from(AlumnoEntidad.class);
        criteriaUpdate.where(criteriaBuilder.equal(root.get("matricula"), alumnoModelo.getMatricula()));
        criteriaUpdate.set(root.get("nombre"),alumnoModelo.getNombre());
        criteriaUpdate.set(root.get("curp"),alumnoModelo.getCurp());
        criteriaUpdate.set(root.get("apellidoPaterno"),alumnoModelo.getApellidoPaterno());
        criteriaUpdate.set(root.get("apellidoMaterno"),alumnoModelo.getApellidoMaterno());
        criteriaUpdate.set(root.get("direccion"),alumnoModelo.getDireccion());
        criteriaUpdate.set(root.get("celular"),alumnoModelo.getCelular());
        criteriaUpdate.set(root.get("telefono"),alumnoModelo.getTelefono());
        criteriaUpdate.set(root.get("correoElectronico"),alumnoModelo.getCorreoElectronico());
        criteriaUpdate.set(root.get("rfc"),alumnoModelo.getRfc());
        criteriaUpdate.set(root.get("nacimiento"),alumnoModelo.getNacimiento());
        modificados += entityManager.createQuery(criteriaUpdate).executeUpdate();
        if ((alumnoModelo.getAlergias() != null && !alumnoModelo.getAlergias().isEmpty())
                || (alumnoModelo.getObservaciones() != null && !alumnoModelo.getObservaciones().isEmpty())) {
            CriteriaUpdate<DatoEntidad> datoEntidadCriteriaUpdate = criteriaBuilder.createCriteriaUpdate(DatoEntidad.class);
            Root<DatoEntidad> datoEntidadRoot = datoEntidadCriteriaUpdate.from(DatoEntidad.class);
            datoEntidadCriteriaUpdate.where(criteriaBuilder.equal(datoEntidadRoot.get("idAlumno"), alumnoModelo.getMatricula()));
            datoEntidadCriteriaUpdate.set(datoEntidadRoot.get("alergias"), alumnoModelo.getAlergias());
            datoEntidadCriteriaUpdate.set(datoEntidadRoot.get("observaciones"), alumnoModelo.getObservaciones());
            modificados += entityManager.createQuery(datoEntidadCriteriaUpdate).executeUpdate();
        }
        return modificados;
    }

}
