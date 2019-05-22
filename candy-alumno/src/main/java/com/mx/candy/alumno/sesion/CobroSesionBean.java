package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.CobroEntidad;
import com.mx.candy.alumno.modelo.CobroModelo;
import com.mx.candy.nucleo.sesion.CatalogoSesionBean;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
public class CobroSesionBean extends CatalogoSesionBean<CobroModelo, CobroEntidad> {

    public int actualiza(CobroModelo cobroModelo) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate<CobroEntidad> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(CobroEntidad.class);
        Root<CobroEntidad> root = criteriaUpdate.from(CobroEntidad.class);
        Predicate predicate = criteriaBuilder.equal(root.get("clave"), cobroModelo.getClave());
        criteriaUpdate.set("descripcion", cobroModelo.getDescripcion()).set("monto", cobroModelo.getMonto()).where(predicate);
        return getEntityManager().createQuery(criteriaUpdate).executeUpdate();
    }

}
