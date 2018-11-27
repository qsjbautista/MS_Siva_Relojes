

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


package mx.com.nmp.ms.sivar.catalogo.web.rest;


import mx.com.nmp.ms.sivar.catalogo.SivarCatalogosApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;


/**
 * Clase de pruebas para la clase {@link CatalogosResource}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SivarCatalogosApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CatalogosResourceITest {

    @LocalServerPort
    private int puerto;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * Constructor de la prueba
     */
    public CatalogosResourceITest() {
        super();
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperarElemento(String, String)}
     */
    @Test
    public void recuperarElementoBaseVacia() {
        final String URL = getURL("/MARCA/OTRO");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0003\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperarElemento(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-vacio-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarElementoNoEncuentraCatalogo() {
        final String URL = getURL("/MARCAS/OTRO");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0003\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperarElemento(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-vacio-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarElementoNoEncuentraElementoBDVacio() {
        final String URL = getURL("/MARCA/OTRO");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0002\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperarElemento(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarElementoNoEncuentraElemento() {
        final String URL = getURL("/MARCA/OTROS");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0002\""));
    }


    /**
     * Prueba de integracion para {@link CatalogosResource#recuperarElemento(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarElemento() {
        final String URL = getURL("/MARCA/OTRO");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(OK, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"abreviatura\":\"OTRO\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperar(String)}
     */
    @Test
    public void recuperarNoSeEncuentraCatalogoSinDatos() {
        final String URL = getURL("/MARCA");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0003\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperar(String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-vacio-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarNoSeEncuentraCatalogo() {
        final String URL = getURL("/MARCAS");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0003\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperar(String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-vacio-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarCatalogoVacio() {
        final String URL = getURL("/MARCA");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(OK, test.getStatusCode());
        assertNotNull(test.getBody());
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#recuperar(String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperar() {
        final String URL = getURL("/MARCA");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(OK, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"abreviatura\":\"LANG\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#autocompletar(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-vacio-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void autocompletarNoSeEncuentraCatalogo() {
        final String URL = getURL("/MARCAS");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("valor", "a");

        ResponseEntity<String> test = testRestTemplate
                .exchange(builder.toUriString(), GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0003\""));
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#autocompletar(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-vacio-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void autocompletarCatalogoVacio() {
        final String URL = getURL("/MARCA");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("valor", "a");

        ResponseEntity<String> test = testRestTemplate
                .exchange(builder.toUriString(), GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(OK, test.getStatusCode());
        assertNotNull(test.getBody());
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#autocompletar(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void autocompletarSinCoincidencia() {
        final String URL = getURL("/MARCA");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("valor", "xx");

        ResponseEntity<String> test = testRestTemplate
                .exchange(builder.toUriString(), GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(OK, test.getStatusCode());
        assertNotNull(test.getBody());
    }

    /**
     * Prueba de integracion para {@link CatalogosResource#autocompletar(String, String)}
     */
    @Test
    @Sql("/db/catalogos-resource-it/data-catalogos-h2.sql")
    @Sql(value = "/db/catalogos-resource-it/data-catalogos-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void autocompletar() {
        final String URL = getURL("/MARCA");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("valor", "A.");

        ResponseEntity<String> test = testRestTemplate
                .exchange(builder.toUriString(), GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(OK, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"abreviatura\":\"LANG\""));
    }

    private String getURL(String ruta) {
        return "http://localhost:" + puerto + "/catalogos/relojes" + ruta;
    }
}