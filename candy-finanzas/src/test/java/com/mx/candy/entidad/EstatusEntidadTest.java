package com.mx.candy.entidad;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class EstatusEntidadTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(EstatusEntidad.class, CatalogoEntidad.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void busca() {
        TypedQuery<EstatusEntidad> typedQuery = entityManager.createNamedQuery("EstatusEntidad.busca", EstatusEntidad.class);
        List<EstatusEntidad> estatusEntidadLista = typedQuery.getResultList();
        Assert.assertNotNull(estatusEntidadLista);
        Assert.assertFalse(estatusEntidadLista.isEmpty());
        Consumer<EstatusEntidad> consumer = estatusEntidad -> {
            Assert.assertNotNull(estatusEntidad);
            Assert.assertNotNull(estatusEntidad.getClave());
            Assert.assertNotNull(estatusEntidad.getDescripcion());
        };
        estatusEntidadLista.forEach(consumer);
    }

}
