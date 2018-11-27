

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


import mx.com.nmp.ms.sivar.catalogo.domain.AbstractCatalogo;
import mx.com.nmp.ms.sivar.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivar.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivar.catalogo.service.CatalogosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


/**
 * Recurso REST que proporciona los puntos finales para consultar los catálogos:
 * <ul>
 *     <li>Marca</li>
 *     <li>Tipo Reloj</li>
 *     <li>Género</li>
 *     <li>Condiciones generales</li>
 *     <li>Desplazamiento comercial</li>
 * </ul>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/catalogos/relojes", produces = APPLICATION_JSON_UTF8_VALUE)
public class CatalogosResource {

    // Pemirte escribir en la vitacora del sistema
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosResource.class);

    /**
     * Referencia al servcio de catalogos
     */
    @Autowired
    private CatalogosService service;

    /**
     * Constrcutor de la clase
     */
    public CatalogosResource() {
        super();
    }

    /**
     * {@link RequestMethod#GET} /catalogos/relojes/{catalogo}/{elemento} : Punto final que
     * expone la función de recuperar un elemento del catálogo especificado.
     *
     * @param catalogo Nombre del catálogo a recuperar
     * @param elemento Nombre del elemento a recuperar
     *
     * @return {@link Catalogo} Documento JSON
     *         {@link HttpStatus#OK} Se recupera el elemento de manera correcta.
     *         {@link HttpStatus#BAD_REQUEST} Si los parametros no son validos.
     *         {@link HttpStatus#NOT_FOUND} Si el catálogo o el elemento no existen.
     *         {@link HttpStatus#INTERNAL_SERVER_ERROR} Error no esperado.
     */
    @GetMapping("/{catalogo}/{elemento}")
    public Catalogo recuperarElemento(@PathVariable String catalogo, @PathVariable String elemento) {
        LOGGER.trace(">> recuperarElemento() > parametros {}, {}", catalogo, elemento);

        AbstractCatalogo entrada = service.recuperarElemento(catalogo, elemento);
        Catalogo retorno = CatalogoFactory.build(entrada);

        LOGGER.trace("<< recuperarElemento() < retorno {}", retorno);

        return retorno;
    }

    /**
     * {@link RequestMethod#GET} /catalogos/relojes/{catalogo} : Punto final que
     * expone la función de recuperar todos los elementos del catálogo especificado.
     *
     * @param catalogo Nombre del catálogo a recuperar
     *
     * @return {@link Catalogo} Documento JSON
     *         {@link HttpStatus#OK} Se recupera el catálog de manera correcta.
     *         {@link HttpStatus#BAD_REQUEST} Si los parametros no son validos.
     *         {@link HttpStatus#NOT_FOUND} Si el catálogo no existen.
     *         {@link HttpStatus#INTERNAL_SERVER_ERROR} Error no esperado.
     */
    @GetMapping("/{catalogo}")
    public Catalogo recuperar(@PathVariable String catalogo) {
        LOGGER.trace(">> recuperar() > parametros {}", catalogo);

        Catalogo retorno;
        List<? extends AbstractCatalogo> entradas = service.recuperar(catalogo);

        if (ObjectUtils.isEmpty(entradas)) {
            retorno = CatalogoFactory.buildEmty();
            LOGGER.warn("El catalogo {} no contiene elementos", catalogo);
        } else {
            retorno = CatalogoFactory.build(entradas);
        }

        LOGGER.trace("<< recuperar() < retorno {}", retorno);

        return retorno;
    }

    /**
     * {@link RequestMethod#GET} /catalogos/relojes/{catalogo}?valor={valor} : Punto final que expone la función de
     * buscar (de manera predictiva) los elementos del catálogo especificado donde la etiqueta contenga el valor indicado.
     *
     * @param catalogo Nombre del catálogo a recuperar
     * @param valor Valor que se espera coinciada con una o parde un etiqueta de un elemento del catálogo
     *
     * @return {@link Catalogo} Documento JSON
     *         {@link HttpStatus#OK} Se recuperan los elemento de manera correcta.
     *         {@link HttpStatus#BAD_REQUEST} Si los parametros no son validos.
     *         {@link HttpStatus#NOT_FOUND} Si el catálogo no existen.
     *         {@link HttpStatus#INTERNAL_SERVER_ERROR} Error no esperado.
     */
    @GetMapping(value = "/{catalogo}", params = {"valor"})
    public Catalogo autocompletar(@PathVariable String catalogo, @RequestParam("valor") String valor) {
        LOGGER.trace(">> autocompletar() > parametros {}, {}", catalogo, valor);

        Catalogo retorno;
        List<? extends AbstractCatalogo> entradas = service.autocompletar(catalogo, valor);

        if (ObjectUtils.isEmpty(entradas)) {
            retorno = CatalogoFactory.buildEmty();
            LOGGER.warn("El catalogo {} no contiene elementos", catalogo);
        } else {
            retorno = CatalogoFactory.build(entradas);
        }

        LOGGER.trace("<< autocompletar() < retorno {}", retorno);

        return retorno;
    }
}
