package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.PeriodoEntidad;
import com.mx.candy.alumno.modelo.PeriodoModelo;
import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import com.mx.candy.nucleo.herramienta.LoggerProducer;
import com.mx.candy.nucleo.modelo.CatalogoModelo;
import com.mx.candy.nucleo.sesion.CatalogoSesionBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class PeriodoSesionBeanTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(PeriodoSesionBean.class, PeriodoEntidad.class, PeriodoModelo.class,
                        CatalogoSesionBean.class, CatalogoModelo.class, CatalogoEntidad.class, LoggerProducer.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private PeriodoSesionBean periodoSesionBean;

    @Test
    public void busca() {
        List<PeriodoModelo> periodoModeloLista = periodoSesionBean.busca();
        assertNotNull(periodoModeloLista);
        assertFalse(periodoModeloLista.isEmpty());
        periodoModeloLista.forEach(periodoModelo -> {
            assertNotNull(periodoModelo);
            assertNotNull(periodoModelo.getClave());
            assertNotNull(periodoModelo.getDescripcion());
        });
    }

}
