

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


import mx.com.nmp.ms.sivar.catalogo.domain.Refrendo;
import mx.com.nmp.ms.sivar.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivar.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivar.catalogo.service.RefrendoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Recurso REST que proporciona los puntos finales para consultar
 * el numero de refrendos a aplicar por el tipo de reloj.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/catalogos/relojes/refrendos", produces = APPLICATION_JSON_UTF8_VALUE)
public class RefrendosResource {

    // Pemirte escribir en la vitacora del sistema
    private static final Logger LOGGER = LoggerFactory.getLogger(RefrendosResource.class);

    /**
     * Referencia al servcio de refrendos
     */
    @Autowired
    private RefrendoService refrendoService;

    /**
     * Constrcutor de la clase
     */
    public RefrendosResource() {
        super();
    }

    @GetMapping("/{tipo_reloj}")
    public Catalogo recuperarElemento(@PathVariable(name = "tipo_reloj") String tipoReloj) {
        LOGGER.trace(">> recuperarElemento() > parametros {}, {}", tipoReloj);

        Refrendo entrada = refrendoService.recuperarElemento(tipoReloj);
        Catalogo retorno = CatalogoFactory.build(entrada);

        LOGGER.trace("<< recuperarElemento() < retorno {}", retorno);

        return retorno;
    }
}
