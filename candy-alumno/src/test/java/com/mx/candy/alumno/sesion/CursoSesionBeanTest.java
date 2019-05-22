package com.mx.candy.alumno.sesion;

import com.mx.candy.alumno.entidad.CursoEntidad;
import com.mx.candy.alumno.entidad.ProgramaEntidad;
import com.mx.candy.alumno.modelo.CursoModelo;
import com.mx.candy.alumno.modelo.ProgramaModelo;
import com.mx.candy.alumno.validacion.NuevoCursoValidacion;
import com.mx.candy.nucleo.entidad.CatalogoEntidad;
import com.mx.candy.nucleo.herramienta.LoggerProducer;
import com.mx.candy.nucleo.herramienta.ValidadorSessionBean;
import com.mx.candy.nucleo.modelo.CatalogoModelo;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CursoSesionBeanTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "prueba.war")
                .addClasses(CursoSesionBean.class, CursoEntidad.class, CursoModelo.class, LoggerProducer.class,
                        ProgramaEntidad.class, CatalogoEntidad.class, ProgramaModelo.class, CatalogoModelo.class,
                        ValidadorSessionBean.class, NuevoCursoValidacion.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private CursoSesionBean cursoSesionBean;

    @Test
    public void busca() {
        List<CursoModelo> cursoModeloLista = cursoSesionBean.busca();
        assertNotNull(cursoModeloLista);
        assertFalse(cursoModeloLista.isEmpty());
        cursoModeloLista.forEach(cursoModelo -> {
            assertNotNull(cursoModelo);
            assertNotNull(cursoModelo.getId());
            assertNotNull(cursoModelo.getProgramaModelo());
            assertNotNull(cursoModelo.getProgramaModelo().getDescripcion());
            assertNotNull(cursoModelo.getGrado());
            assertNotNull(cursoModelo.getGrupo());
            assertNotNull(cursoModelo.getInicio());
            assertNotNull(cursoModelo.getFin());
            assertNotNull(cursoModelo.getBeca());
        });
    }

    @Test
    public void buscaAlumnos() {

    }

    @Test
    public void inserta() {
        CursoModelo cursoModelo = new CursoModelo();
        cursoModelo.setProgramaModelo(new ProgramaModelo((short)1));
        cursoModelo.setBeca((short)0);
        cursoModelo.setFin(new Date());
        cursoModelo.setInicio(new Date());
        cursoModelo.setGrado((short)1);
        cursoModelo.setGrupo('B');
        cursoSesionBean.inserta(cursoModelo);
        assertFalse(cursoModelo.getId() == 0);
    }

    @Test
    public void elimina() {
        cursoSesionBean.elimina(0);
    }

    @Test
    public void actualiza() {
        CursoModelo cursoModelo = new CursoModelo(1);
        cursoModelo.setProgramaModelo(new ProgramaModelo((short)1));
        cursoModelo.setBeca((short)15);
        cursoModelo.setFin(new Date());
        cursoModelo.setInicio(new Date());
        cursoModelo.setGrado((short)2);
        cursoModelo.setGrupo('C');
        int modificados = cursoSesionBean.actualiza(cursoModelo);
    }
}
