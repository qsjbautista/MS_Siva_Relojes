

/*
 *
 *
 *
 * <p><a href="https://wiki.quarksoft.net/display/NMPSIVARELOJES/Home">SIVA Relojes</a></p>
 *
 * <p><b><a href="https://quarksoft.net/">Quarksoft S.A.P.I. de C.V. Copyrigth © 2018</a></b></p>
 *
 *
 */


package mx.com.nmp.ms.sivar.catalogo.service;


import mx.com.nmp.ms.sivar.catalogo.SivarCatalogosApplication;
import mx.com.nmp.ms.sivar.catalogo.domain.AbstractCatalogo;
import mx.com.nmp.ms.sivar.catalogo.domain.Marca;
import mx.com.nmp.ms.sivar.catalogo.exception.BadRequestException;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import mx.com.nmp.ms.sivar.catalogo.repository.CatalogosRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_0003;
import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_9999;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


/**
 * Clase de pruebas para la clase {@link CatalogosService}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SivarCatalogosApplication.class)
public class CatalogosServiceUTest {

    @MockBean
    private CatalogosRepository catalogosRepository;

    @MockBean
    private CatalogosRepositoryManager catalogosRepositoryManager;

    @Autowired
    private CatalogosService catalogosService;

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto1() {
        catalogosService.recuperarElemento(null, null);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto2() {
        catalogosService.recuperarElemento("  ", null);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto3() {
        catalogosService.recuperarElemento("MARCA", null);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto4() {
        catalogosService.recuperarElemento("MARCA", "  ");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @Test(expected = InternalServerErrorException.class)
    public void recuperarElementoErrorInternoRecuperarRepositorio() {
        String msj = "Error programado para pruebas";
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenThrow(new InternalServerErrorException(NMP_SRC_9999, msj, msj));

        catalogosService.recuperarElemento("MARCA", "LANG");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @Test(expected = NotFoundException.class)
    public void recuperarElementoErrorRecuperarRepositorio() {
        String msj = "Error programado para pruebas";
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenThrow(new NotFoundException(NMP_SRC_0003, msj, msj));

        catalogosService.recuperarElemento("MARCAX", "LANG");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @SuppressWarnings("unchecked")
    @Test(expected = InternalServerErrorException.class)
    public void recuperarElementoErrorRecuperarElemento() {
        String msj = "Error programado para pruebas";
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findByAbreviatura(anyString())).thenThrow(new RuntimeException(msj));

        catalogosService.recuperarElemento("MARCAX", "LANG");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @SuppressWarnings("unchecked")
    @Test(expected = NotFoundException.class)
    public void recuperarElementoNoExisteElemento() {
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findByAbreviatura(anyString())).thenReturn(null);

        catalogosService.recuperarElemento("MARCA", "LANGXX");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperarElemento(String, String)}
     */
    @Test
    @SuppressWarnings("unchecked")
    public void recuperarElemento() {
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findByAbreviatura(anyString())).thenReturn(new Marca());

        AbstractCatalogo test = catalogosService.recuperarElemento("MARCA", "LANG");
        assertNotNull(test);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperar(String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarParametroIncorrecto1() {
        catalogosService.recuperar(null);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperar(String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarParametroIncorrecto2() {
        catalogosService.recuperar("  ");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperar(String)}
     */
    @Test(expected = InternalServerErrorException.class)
    public void recuperarErrorInternoRecuperarRepositorio() {
        String msj = "Error programado para pruebas";
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenThrow(new InternalServerErrorException(NMP_SRC_9999, msj, msj));

        catalogosService.recuperar("MARCA");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperar(String)}
     */
    @SuppressWarnings("unchecked")
    @Test(expected = InternalServerErrorException.class)
    public void recuperarErrorRecuperarCatalogo() {
        String msj = "Error programado para pruebas";
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findAll()).thenThrow(new RuntimeException(msj));

        catalogosService.recuperar("MARCA");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperar(String)}
     */
    @Test
    @SuppressWarnings("unchecked")
    public void recuperarCatalogoVacio() {
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findAll()).thenReturn(new ArrayList());

        List test = catalogosService.recuperar("MARCA");

        assertNotNull(test);
        assertTrue(test.isEmpty());
    }

    /**
     * Prueba de unidad para {@link CatalogosService#recuperar(String)}
     */
    @Test
    @SuppressWarnings("unchecked")
    public void recuperar() {
        List<Marca> cm = new ArrayList();

        cm.add(new Marca());
        cm.add(new Marca());

        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findAll()).thenReturn(cm);

        List test = catalogosService.recuperar("MARCA");

        assertNotNull(test);
        assertFalse(test.isEmpty());
        assertEquals(test.size(), cm.size());
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void autocompletarParametroIncorrecto1() {
        catalogosService.autocompletar(null, null);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void autocompletarParametroIncorrecto2() {
        catalogosService.autocompletar("  ", null);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void autocompletarParametroIncorrecto3() {
        catalogosService.autocompletar("MARCA", null);
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void autocompletarParametroIncorrecto4() {
        catalogosService.autocompletar("MARCA", "  ");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @Test(expected = InternalServerErrorException.class)
    public void autocompletarErrorInternoRecuperarRepositorio() {
        String msj = "Error programado para pruebas";
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenThrow(new InternalServerErrorException(NMP_SRC_9999, msj, msj));

        catalogosService.autocompletar("MARCA", "A");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @SuppressWarnings("unchecked")
    @Test(expected = InternalServerErrorException.class)
    public void autocompletarErrorRecuperar() {
        String msj = "Error programado para pruebas";
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findByEtiquetaContaining(anyString())).thenThrow(new RuntimeException(msj));

        catalogosService.autocompletar("MARCA", "A");
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @Test
    @SuppressWarnings("unchecked")
    public void autocompletarSinResultado() {
        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findByEtiquetaContaining(anyString())).thenReturn(new ArrayList());

        List test = catalogosService.autocompletar("MARCA", "A.");

        assertNotNull(test);
        assertTrue(test.isEmpty());
    }

    /**
     * Prueba de unidad para {@link CatalogosService#autocompletar(String, String)}
     */
    @Test
    @SuppressWarnings("unchecked")
    public void autocompletar() {
        List<Marca> cm = new ArrayList<>();

        cm.add(new Marca());
        cm.add(new Marca());
        cm.add(new Marca());

        when(catalogosRepositoryManager.recuperarRepositorio(anyString()))
                .thenReturn(catalogosRepository);
        when(catalogosRepository.findByEtiquetaContaining(anyString())).thenReturn(cm);

        List test = catalogosService.autocompletar("MARCA", "A");

        assertNotNull(test);
        assertFalse(test.isEmpty());
        assertEquals(test.size(), cm.size());
    }
}