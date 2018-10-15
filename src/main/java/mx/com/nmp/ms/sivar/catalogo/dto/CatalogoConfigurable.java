

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


package mx.com.nmp.ms.sivar.catalogo.dto;


import mx.com.nmp.ms.sivar.catalogo.domain.Configuracion;

import java.io.Serializable;


/**
 * Contrato que deben cumplir los catálogos configurables, permite recuperar la configuración del catalogo.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface CatalogoConfigurable extends Serializable {
    /**
     * Permite recuperar la confguración del catálogo.
     *
     * @return Valor de la configuración del catálogo.
     */
    Configuracion getConfiguracion();
}
