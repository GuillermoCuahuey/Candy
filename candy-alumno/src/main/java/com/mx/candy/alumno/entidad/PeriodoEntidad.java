package com.mx.candy.alumno.entidad;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "periodo", schema = "alumno")
@NamedQuery(name = "PeriodoEntidad.busca", query = "SELECT p FROM PeriodoEntidad p")
public class PeriodoEntidad extends CatalogoEntidad {
}
