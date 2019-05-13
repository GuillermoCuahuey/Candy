package com.mx.candy.entidad;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "programa", schema = "finanzas")
@NamedQuery(name = "ProgramaEntidad.busca", query = "SELECT p FROM ProgramaEntidad p")
public class ProgramaEntidad extends CatalogoEntidad {
}
