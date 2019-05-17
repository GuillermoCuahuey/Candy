package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.AlumnoEntidad;
import com.mx.candy.alumno.modelo.AlumnoBaseModelo;
import com.mx.candy.alumno.modelo.AlumnoModelo;
import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import com.mx.candy.nucleo.herramienta.LoggerProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.spi.ArquillianProxyException;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(Arquillian.class)
public class AlumnoSesionBeanTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(CatalogoEntidad.class, LoggerProducer.class, AlumnoSesionBean.class, AlumnoModelo.class, AlumnoBaseModelo.class)
                .addPackage(AlumnoEntidad.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private AlumnoSesionBean alumnoSesionBean;

    @Test
    public void busca() {
        List<AlumnoModelo> alumnoModeloLista = alumnoSesionBean.busca();
        Assert.assertNotNull(alumnoModeloLista);
        Assert.assertFalse(alumnoModeloLista.isEmpty());
        alumnoModeloLista.forEach(alumnoModelo -> {
            Assert.assertNotNull(alumnoModelo);
            Assert.assertNotNull(alumnoModelo.getAlergias());
            Assert.assertNotNull(alumnoModelo.getApellidoMaterno());
            Assert.assertNotNull(alumnoModelo.getApellidoPaterno());
            Assert.assertNotNull(alumnoModelo.getCelular());
            Assert.assertNotNull(alumnoModelo.getCurp());
            Assert.assertNotNull(alumnoModelo.getDireccion());
            Assert.assertNotNull(alumnoModelo.getEstatus());
            Assert.assertNotNull(alumnoModelo.getMatricula());
            Assert.assertNotNull(alumnoModelo.getNacimiento());
            Assert.assertNotNull(alumnoModelo.getNombre());
            Assert.assertNotNull(alumnoModelo.getObservaciones());
            Assert.assertNotNull(alumnoModelo.getRfc());
            Assert.assertNotNull(alumnoModelo.getTelefono());
        });
    }

    @Test
    public void buscaBase() {
        List<AlumnoBaseModelo> alumnoBaseModeloLista = alumnoSesionBean.buscaEstatus();
        Assert.assertNotNull(alumnoBaseModeloLista);
        Assert.assertFalse(alumnoBaseModeloLista.isEmpty());
        alumnoBaseModeloLista.forEach(alumnoBaseModelo -> {
            Assert.assertNotNull(alumnoBaseModelo);
            Assert.assertNotNull(alumnoBaseModelo.getMatricula());
            Assert.assertNotNull(alumnoBaseModelo.getNombre());
            Assert.assertNotNull(alumnoBaseModelo.getApellidoPaterno());
            Assert.assertNotNull(alumnoBaseModelo.getApellidoMaterno());
        });
    }

    @Test
    public void buscaMatricula() {
        AlumnoModelo alumnoModelo = alumnoSesionBean.busca("182104370018");
        Assert.assertNotNull(alumnoModelo);
        Assert.assertNotNull(alumnoModelo.getAlergias());
        Assert.assertNotNull(alumnoModelo.getApellidoMaterno());
        Assert.assertNotNull(alumnoModelo.getApellidoPaterno());
        Assert.assertNotNull(alumnoModelo.getCelular());
        Assert.assertNotNull(alumnoModelo.getCurp());
        Assert.assertNotNull(alumnoModelo.getDireccion());
        Assert.assertNotNull(alumnoModelo.getEstatus());
        Assert.assertNotNull(alumnoModelo.getMatricula());
        Assert.assertNotNull(alumnoModelo.getNacimiento());
        Assert.assertNotNull(alumnoModelo.getNombre());
        Assert.assertNotNull(alumnoModelo.getObservaciones());
        Assert.assertNotNull(alumnoModelo.getRfc());
        Assert.assertNotNull(alumnoModelo.getTelefono());
    }

    @Test(expected = ArquillianProxyException.class)
    public void insertaNulo() {
        alumnoSesionBean.inserta(null);
    }

    @Test(expected = ArquillianProxyException.class)
    public void insertaObjectoCampoNulo() {
        AlumnoModelo alumnoModelo = new AlumnoModelo();
        alumnoSesionBean.inserta(alumnoModelo);
    }

    @Test
    public void insertaMandatorio() throws ParseException {
        AlumnoModelo alumnoModelo = new AlumnoModelo();
        alumnoModelo.setMatricula("182104370018");
        alumnoModelo.setCurp("BADD110313HCMLNS09");
        alumnoModelo.setNombre("Adame");
        alumnoModelo.setApellidoPaterno("Gallardo");
        alumnoModelo.setApellidoMaterno("Navid");
        alumnoModelo.setDireccion("15 poniente 512 San Andres Cholula");
        alumnoModelo.setCelular("2227702138");
        alumnoModelo.setTelefono("2224824980");
        alumnoModelo.setRfc("qwerasdf12345");
        alumnoModelo.setCorreoElectronico("ejemplo@nahtechnology.com");
        alumnoModelo.setNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2000-09-05"));
        //alumnoModelo.setAlergias("");
        //alumnoModelo.setObservaciones("");
        alumnoSesionBean.inserta(alumnoModelo);
        Assert.assertNotNull(alumnoModelo);
    }

    @Test
    public void insertaDetalle() throws ParseException {
        AlumnoModelo alumnoModelo = new AlumnoModelo();
        alumnoModelo.setMatricula("182104370018");
        alumnoModelo.setCurp("BADD110313HCMLNS09");
        alumnoModelo.setNombre("Adame");
        alumnoModelo.setApellidoPaterno("Gallardo");
        alumnoModelo.setApellidoMaterno("Navid");
        alumnoModelo.setDireccion("15 poniente 512 San Andres Cholula");
        alumnoModelo.setCelular("2227702138");
        alumnoModelo.setTelefono("2224824980");
        alumnoModelo.setRfc("qwerasdf12345");
        alumnoModelo.setCorreoElectronico("ejemplo@nahtechnology.com");
        alumnoModelo.setNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2000-09-05"));
        alumnoModelo.setAlergias("cafeaspirina");
        alumnoModelo.setObservaciones("el alumno necesita ayuda con las escaleras ya que tiene una silla de ruedas");
        alumnoSesionBean.inserta(alumnoModelo);
        Assert.assertNotNull(alumnoModelo);
    }

    @Test
    public void elimina() {
        int modificados = alumnoSesionBean.elimina("182104370018");
        Assert.assertFalse(modificados == 0);
    }

    @Test
    public void actualiza() throws ParseException {
        AlumnoModelo alumnoModelo = new AlumnoModelo();
        alumnoModelo.setMatricula("182104370018");
        alumnoModelo.setCurp("BADD110313HCMLNS10");
        alumnoModelo.setNombre("Adama");
        alumnoModelo.setApellidoPaterno("Gallarda");
        alumnoModelo.setApellidoMaterno("Navida");
        alumnoModelo.setDireccion("15 poniente 512 San Andres Cholule");
        alumnoModelo.setCelular("2227702140");
        alumnoModelo.setTelefono("2224824982");
        alumnoModelo.setRfc("qwerasdf12347");
        alumnoModelo.setCorreoElectronico("ejemplo2@nahtechnology.com");
        alumnoModelo.setNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2000-09-07"));
        alumnoModelo.setAlergias("cafeaspirinas");
        alumnoModelo.setObservaciones("el alumno necesita ayuda con las escaleras ya que tiene una silla de rueda");
        int modificados = alumnoSesionBean.actualiza(alumnoModelo);
        Assert.assertFalse(modificados == 0);
    }
}