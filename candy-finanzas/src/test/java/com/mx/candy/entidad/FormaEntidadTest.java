package com.mx.candy.entidad;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@RunWith(Arquillian.class)
public class FormaEntidadTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(FormaEntidad.class, CatalogoEntidad.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void busca() {
        TypedQuery<FormaEntidad> typedQuery = entityManager.createNamedQuery("FormaEntidad.busca", FormaEntidad.class);
        List<FormaEntidad> formaEntidadLista = typedQuery.getResultList();
        Assert.assertNotNull(formaEntidadLista);
        Assert.assertFalse(formaEntidadLista.isEmpty());
        formaEntidadLista.forEach(formaEntidad -> {
            Assert.assertNotNull(formaEntidad);
            Assert.assertNotNull(formaEntidad.getClave());
            Assert.assertNotNull(formaEntidad.getDescripcion());
        });
    }
}
