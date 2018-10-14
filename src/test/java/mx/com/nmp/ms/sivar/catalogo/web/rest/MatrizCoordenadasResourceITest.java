

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;


/**
 * Clase de pruebas para la clase {@link MatrizCoordenadasResource}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SivarCatalogosApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatrizCoordenadasResourceITest {

    @LocalServerPort
    private int puerto;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * Constructor de la prueba
     */
    public MatrizCoordenadasResourceITest() {
        super();
    }

    /**
     * Prueba de integracion para {@link MatrizCoordenadasResource#recuperarElemento(String, String)}
     */
    @Test
    public void recuperarElementoBDVacia() {
        final String URL = getURL("/SNES/ALTO");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0002\""));
    }

    /**
     * Prueba de integracion para {@link MatrizCoordenadasResource#recuperarElemento(String, String)}
     */
    @Test
    @Sql("/db/matriz-resource-it/data-matriz-h2.sql")
    @Sql(value = "/db/matriz-resource-it/data-matriz-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarElementoNoExiste() {
        final String URL = getURL("/SNES/ALTOS");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(NOT_FOUND, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0002\""));
    }

    /**
     * Prueba de integracion para {@link MatrizCoordenadasResource#recuperarElemento(String, String)}
     */
    @Test
    @Sql("/db/matriz-resource-it/data-matriz-h2.sql")
    @Sql(value = "/db/matriz-resource-it/data-matriz-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarElementoInvalido() {
        final String URL = getURL("/DMTR/ALTO");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(FORBIDDEN, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"codigo\":\"NMP_SRC_0004\""));
    }

    /**
     * Prueba de integracion para {@link MatrizCoordenadasResource#recuperarElemento(String, String)}
     */
    @Test
    @Sql("/db/matriz-resource-it/data-matriz-h2.sql")
    @Sql(value = "/db/matriz-resource-it/data-matriz-limpiar-h2.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void recuperarElemento() {
        final String URL = getURL("/SNES/EXLT");
        ResponseEntity<String> test = testRestTemplate.exchange(URL, GET, null, String.class);
        System.out.printf(">>>> %s", test.getBody());

        assertEquals(OK, test.getStatusCode());
        assertNotNull(test.getBody());
        assertTrue(test.getBody().contains("\"abreviatura\":\"SNES_EXLT\""));
        assertTrue(test.getBody().contains("\"factor\":0.9000"));
    }

    private String getURL(String ruta) {
        return "http://localhost:" + puerto + "/catalogos/relojes/matriz" + ruta;
    }
}