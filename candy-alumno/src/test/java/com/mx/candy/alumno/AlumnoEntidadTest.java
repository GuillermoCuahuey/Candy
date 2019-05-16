package com.mx.candy.alumno;

import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
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
public class AlumnoEntidadTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(AlumnoEntidad.class, EstatusEntidad.class, CatalogoEntidad.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/Persistence.xml");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void busca() {
        TypedQuery<AlumnoEntidad> typedQuery = entityManager.createNamedQuery("AlumnoEntidad.busca", AlumnoEntidad.class);
        List<AlumnoEntidad> alumnoEntidadLista = typedQuery.getResultList();
        Assert.assertNotNull(alumnoEntidadLista);
        Assert.assertFalse(alumnoEntidadLista.isEmpty());
        alumnoEntidadLista.forEach( alumnoEntidad -> {
            Assert.assertNotNull(alumnoEntidad);
            Assert.assertNotNull(alumnoEntidad.getApellidoMaterno());
            Assert.assertNotNull(alumnoEntidad.getApellidoPaterno());
            Assert.assertNotNull(alumnoEntidad.getCelular());
            Assert.assertNotNull(alumnoEntidad.getCurp());
            Assert.assertNotNull(alumnoEntidad.getDireccion());
            Assert.assertNotNull(alumnoEntidad.getEstatusEntidad().getDescripcion());
            Assert.assertNotNull(alumnoEntidad.getMatricula());
            Assert.assertNotNull(alumnoEntidad.getNacimiento());
            Assert.assertNotNull(alumnoEntidad.getNombre());
            Assert.assertNotNull(alumnoEntidad.getRfc());
            Assert.assertNotNull(alumnoEntidad.getTelefono());
        });
    }

}
