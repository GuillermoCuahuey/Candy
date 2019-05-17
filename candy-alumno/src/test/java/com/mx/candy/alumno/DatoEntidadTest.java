package com.mx.candy.alumno;

import com.mx.candy.alumno.entidad.DatoEntidad;
import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@RunWith(Arquillian.class)
public class DatoEntidadTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addPackage(DatoEntidad.class.getPackage()).addClass(CatalogoEntidad.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/persistence.xml");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void busca() {
        List<DatoEntidad> datoEntidadLista = entityManager.createNamedQuery("DatoEntidad.busca", DatoEntidad.class).getResultList();
        Assert.assertNotNull(datoEntidadLista);
        Assert.assertFalse(datoEntidadLista.isEmpty());
        datoEntidadLista.forEach(datoEntidad -> {
            Assert.assertNotNull(datoEntidad);
        });
    }
}
