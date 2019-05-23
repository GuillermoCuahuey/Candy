package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.CobroEntidad;
import com.mx.candy.alumno.entidad.CursoCobroEntidad;
import com.mx.candy.alumno.entidad.CursoCobroEntidadPK;
import com.mx.candy.alumno.modelo.CobroModelo;
import com.mx.candy.nucleo.sesion.CatalogoSesionBean;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;

/**
 * Metodos para la manupulación de monto de un curso.
 * @author Antonio Francisco Alonso Valerdi
 * @Since 0.1
 */
@Stateless
public class CobroSesionBean extends CatalogoSesionBean<CobroModelo, CobroEntidad> {

    /**
     * Actualiza el monto de pago por concepto concepto de un curso.
     * @param idCurso Identificador del curso.
     * @param idCobro Identificador del concepto de pago.
     * @param monto Monto a ser actualizado
     */
    public void actualiza(@NotNull Integer idCurso, @NotNull Short idCobro, @NotNull Float monto) {
        logger.fine("idCurso:".concat(idCurso.toString()).concat(" idCobro:").concat(idCobro.toString()).concat(" monto:").concat(monto.toString()));
        CursoCobroEntidad cursoCobroEntidad = entityManager.find(CursoCobroEntidad.class, new CursoCobroEntidadPK(idCobro, idCurso));
        cursoCobroEntidad.setMonto(monto);
    }

}
