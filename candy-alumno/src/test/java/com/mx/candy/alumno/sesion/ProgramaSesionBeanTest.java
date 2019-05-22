package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.ProgramaEntidad;
import com.mx.candy.alumno.modelo.ProgramaModelo;
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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class ProgramaSesionBeanTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(ProgramaSesionBean.class, ProgramaEntidad.class, ProgramaModelo.class,
                        CatalogoSesionBean.class, CatalogoModelo.class, CatalogoEntidad.class, LoggerProducer.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private ProgramaSesionBean programaSesionBean;

    @Test
    public void busca() {
        List<ProgramaModelo> programaModeloLista = programaSesionBean.busca();
        Assert.assertNotNull(programaModeloLista);
        Assert.assertFalse(programaModeloLista.isEmpty());
        programaModeloLista.forEach(programaModelo -> {
            Assert.assertNotNull(programaModelo);
            Assert.assertNotNull(programaModelo.getClave());
            Assert.assertNotNull(programaModelo.getDescripcion());
        });
    }

    @Test
    public void buscaId() {
        ProgramaModelo programaModelo = programaSesionBean.busca((short)1);
        Assert.assertNotNull(programaModelo);
        Assert.assertNotNull(programaModelo.getDescripcion());
        Assert.assertNotNull(programaModelo.getClave());
    }

    @Test
    public void actualiza() {
        ProgramaModelo programaModelo = new ProgramaModelo((short)1);
        programaModelo.setDescripcion("Gastronomía");
        int modificaciones = programaSesionBean.actualiza(programaModelo);
        Assert.assertFalse(modificaciones == 0);
    }

    @Test
    public void inserta() {
        programaSesionBean.inserta("ingles");
    }

}
