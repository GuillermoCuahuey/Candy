package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.CobroEntidad;
import com.mx.candy.alumno.modelo.CobroModelo;
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
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CobroSesionBeanTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(CobroSesionBean.class, CobroEntidad.class, CobroModelo.class,
                        CatalogoSesionBean.class, CatalogoModelo.class, CatalogoEntidad.class, LoggerProducer.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private CobroSesionBean cobroSesionBean;

    @Test
    public void busca() {
        List<CobroModelo> cobroModeloLista = cobroSesionBean.busca();
        assertNotNull(cobroModeloLista);
        assertFalse(cobroModeloLista.isEmpty());
        cobroModeloLista.forEach(cobroModelo -> {
            assertNotNull(cobroModelo);
            assertNotNull(cobroModelo.getMonto());
            assertNotNull(cobroModelo.getClave());
            assertNotNull(cobroModelo.getDescripcion());
        });
    }

    @Test
    public void actualiza() {
        CobroModelo cobroModelo = new CobroModelo();
        cobroModelo.setClave((short)1);
        cobroModelo.setDescripcion("Inscripcion");
        cobroModelo.setMonto((float)10000.01);
        int modificados = cobroSesionBean.actualiza(cobroModelo);
        assertFalse(modificados == 0);
    }
}
