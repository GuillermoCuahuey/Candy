package com.mx.candy.entidad;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entidad que representa una forma de pago
 */
@Entity
@Table(name = "forma", schema = "finanzas")
@NamedQuery(name = "FormaEntidad.busca", query = "SELECT f FROM FormaEntidad f")
public class FormaEntidad extends CatalogoEntidad {

}
