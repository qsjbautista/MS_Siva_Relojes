

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


import mx.com.nmp.ms.sivar.catalogo.domain.MatrizCoordenadas;
import mx.com.nmp.ms.sivar.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivar.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivar.catalogo.service.MatrizCoordenadasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


/**
 * Recurso REST que proporciona los puntos finales para consultar
 * el factor a aplicar por la combinación de condiciones generales y desplazamiento comercial.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/catalogos/relojes/matriz", produces = APPLICATION_JSON_UTF8_VALUE)
public class MatrizCoordenadasResource {

    // Pemirte escribir en la vitacora del sistema
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrizCoordenadasResource.class);

    /**
     * Referencia al servcio de matriz de coordenadas.
     */
    @Autowired
    private MatrizCoordenadasService matrizCoordenadasService;

    /**
     * Constrcutor de la clase
     */
    public MatrizCoordenadasResource() {
        super();
    }

    /**
     * {@link RequestMethod#GET} /catalogos/relojes/matriz/{condicion}/{desplazamiento} : Punto final que expone
     * la función de recuperar un elemento del catálogo matriz de coordenadas.
     *
     * @param condicion Nombre del elemento del catálogo condiciones generales
     * @param desplazamiento Nombre del elemento del catálogo desplazamiento comercial
     *
     * @return {@link Catalogo} Documento JSON
     *         {@link HttpStatus#OK} Se recupera el elemento de manera correcta.
     *         {@link HttpStatus#BAD_REQUEST} Si los parametros no son validos.
     *         {@link HttpStatus#FORBIDDEN} Si el elemento no es valido {@link MatrizCoordenadas#valida}
     *         {@link HttpStatus#NOT_FOUND} Si el elemento no existen.
     *         {@link HttpStatus#INTERNAL_SERVER_ERROR} Error no esperado.
     */
    @GetMapping("/{condicion}/{desplazamiento}")
    public Catalogo recuperarElemento(@PathVariable String condicion, @PathVariable String desplazamiento) {
        LOGGER.trace(">> recuperarElemento() > parametros {}, {}", condicion, desplazamiento);

        MatrizCoordenadas entrada = matrizCoordenadasService.recuperarElemento(condicion, desplazamiento);
        Catalogo retorno = CatalogoFactory.build(entrada);

        LOGGER.trace("<< recuperarElemento() < retorno {}", retorno);

        return retorno;
    }
}
