package com.mx.candy.entidad;

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
public class ContactoEntidadTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClass(ContactoEntidad.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void busca() {
        TypedQuery<ContactoEntidad> typedQuery = entityManager.createNamedQuery("ContactoEntidad.busca", ContactoEntidad.class);
        List<ContactoEntidad> contactoEntidadLista = typedQuery.getResultList();
        Assert.assertNotNull(contactoEntidadLista);
        Assert.assertFalse(contactoEntidadLista.isEmpty());
        contactoEntidadLista.forEach(c -> {
            Assert.assertNotNull(c);
            Assert.assertNotNull(c.getNombre());
            Assert.assertNotNull(c.getTelefono());
        });
    }
}
