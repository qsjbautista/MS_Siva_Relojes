

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
import mx.com.nmp.ms.sivar.catalogo.domain.MatrizCoordenadas;
import mx.com.nmp.ms.sivar.catalogo.exception.BadRequestException;
import mx.com.nmp.ms.sivar.catalogo.exception.FactorNoValidException;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import mx.com.nmp.ms.sivar.catalogo.repository.MatrizCoordenadasRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


/**
 * Clase de pruebas para la clase {@link MatrizCoordenadasService}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SivarCatalogosApplication.class)
public class MatrizCoordenadasServiceUTest {

    @MockBean
    private MatrizCoordenadasRepository matrizCoordenadasRepository;

    @Autowired
    private MatrizCoordenadasService matrizCoordenadasService;


    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto1() {
        matrizCoordenadasService.recuperarElemento(null, null);
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto2() {
        matrizCoordenadasService.recuperarElemento("  ", null);
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto3() {
        matrizCoordenadasService.recuperarElemento("SNES", null);
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = BadRequestException.class)
    public void recuperarElementoParametroIncorrecto4() {
        matrizCoordenadasService.recuperarElemento("SNES", "  ");
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = InternalServerErrorException.class)
    public void recuperarElementoErrorRecuperarElemento() {
        when(matrizCoordenadasRepository.findByCondicionAndDesplazamiento(anyString(), anyString()))
                .thenThrow(new RuntimeException("Error programado para pruebas"));

        matrizCoordenadasService.recuperarElemento("SNES", "ALTO");
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = NotFoundException.class)
    public void recuperarElementoNoExiste() {
        when(matrizCoordenadasRepository.findByCondicionAndDesplazamiento(anyString(), anyString())).thenReturn(null);

        matrizCoordenadasService.recuperarElemento("SNES", "ALTOS");
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = FactorNoValidException.class)
    public void recuperarElementoNoValido() {
        MatrizCoordenadas mc = new MatrizCoordenadas();
        mc.setValida(false);

        when(matrizCoordenadasRepository.findByCondicionAndDesplazamiento(anyString(), anyString())).thenReturn(mc);

        matrizCoordenadasService.recuperarElemento("SNES", "ALTOS");
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = FactorNoValidException.class)
    public void recuperarElementoNoValidoFactorNegativo() {
        MatrizCoordenadas mc = new MatrizCoordenadas();
        mc.setValida(true);
        mc.setFactor(BigDecimal.valueOf(-1));

        when(matrizCoordenadasRepository.findByCondicionAndDesplazamiento(anyString(), anyString())).thenReturn(mc);

        matrizCoordenadasService.recuperarElemento("SNES", "ALTOS");
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test(expected = FactorNoValidException.class)
    public void recuperarElementoNoValidoFactorCero() {
        MatrizCoordenadas mc = new MatrizCoordenadas();
        mc.setValida(true);
        mc.setFactor(BigDecimal.valueOf(0));

        when(matrizCoordenadasRepository.findByCondicionAndDesplazamiento(anyString(), anyString())).thenReturn(mc);

        matrizCoordenadasService.recuperarElemento("SNES", "ALTOS");
    }

    /**
     * Prueba de unidad para {@link MatrizCoordenadasService#recuperarElemento(String, String)}
     */
    @Test
    public void recuperarElemento() {
        MatrizCoordenadas mc = new MatrizCoordenadas();
        mc.setValida(true);
        mc.setFactor(BigDecimal.valueOf(0.8500));

        when(matrizCoordenadasRepository.findByCondicionAndDesplazamiento(anyString(), anyString())).thenReturn(mc);

        MatrizCoordenadas test = matrizCoordenadasService.recuperarElemento("SNES", "ALTOS");

        assertNotNull(test);
        assertTrue(test.getValida());
        assertEquals(BigDecimal.valueOf(0.8500), test.getFactor());
    }
}