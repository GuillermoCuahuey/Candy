package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.EstatusEntidad;
import com.mx.candy.alumno.modelo.EstatusModelo;
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
public class EstatusSesionBeanTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(CatalogoEntidad.class, CatalogoModelo.class, LoggerProducer.class, CatalogoSesionBean.class,
                        EstatusEntidad.class, EstatusModelo.class, EstatusSesionBean.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private EstatusSesionBean estatusSesionBean;

    @Test
    public void busca() {
        List<EstatusModelo> estatusEntidadLista = estatusSesionBean.busca();
        Assert.assertNotNull(estatusEntidadLista);
        Assert.assertFalse(estatusEntidadLista.isEmpty());
        estatusEntidadLista.forEach(estatusModelo -> {
            Assert.assertNotNull(estatusModelo);
            Assert.assertNotNull(estatusModelo.getClave());
            Assert.assertNotNull(estatusModelo.getDescripcion());
        });
    }

}
