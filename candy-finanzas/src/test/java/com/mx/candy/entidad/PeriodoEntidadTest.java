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

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class PeriodoEntidadTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(PeriodoEntidad.class, CatalogoEntidad.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void busca() {
        TypedQuery<PeriodoEntidad> typedQuery = entityManager.createNamedQuery("PeriodoEntidad.busca", PeriodoEntidad.class);
        List<PeriodoEntidad> periodoEntidadLista = typedQuery.getResultList();
        Assert.assertNotNull(periodoEntidadLista);
        Assert.assertFalse(periodoEntidadLista.isEmpty());
        periodoEntidadLista.forEach(p -> {
            Assert.assertNotNull(p);
            Assert.assertNotNull(p.getClave());
            Assert.assertNotNull(p.getDescripcion());
        });
    }

}
