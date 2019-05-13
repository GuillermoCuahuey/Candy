package com.mx.candy.entidad;


import com.mx.candy.nucleo.entidad.CatalogoEntidad;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "estatus", schema = "finanzas")
@NamedQuery(name = "EstatusEntidad.busca", query = "SELECT e FROM EstatusEntidad e")
public class EstatusEntidad extends CatalogoEntidad {
}
