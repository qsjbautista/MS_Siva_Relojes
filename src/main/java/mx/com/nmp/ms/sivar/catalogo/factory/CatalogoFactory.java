

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


package mx.com.nmp.ms.sivar.catalogo.factory;


import mx.com.nmp.ms.sivar.catalogo.domain.Configuracion;
import mx.com.nmp.ms.sivar.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivar.catalogo.dto.CatalogoConfigurable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Fabrica que se encarga de crear objetos del dto {@link Catalogo}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public final class CatalogoFactory {
    /**
     * Constructor.
     */
    private CatalogoFactory() {
        super();
    }

    public static Catalogo buildEmty() {
        Catalogo catalogo = new Catalogo();
        catalogo.setElementos(new ArrayList<>());
        return catalogo;
    }

    /**
     * Crear un objeto {@link Catalogo}
     *
     * @param configuracion Configuración del catalogo {@link Configuracion}
     * @param elementos Elemtos del catálogo.
     *
     * @return Objeto {@link Catalogo}
     */
    public static Catalogo build(Configuracion configuracion, List<? extends Serializable> elementos) {
        Catalogo catalogo = getCatalogo(configuracion);
        catalogo.setElementos(elementos);
        return catalogo;
    }

    /**
     * Crear un objeto {@link Catalogo}
     *
     * @param elemento Elemento del catálogo {@link CatalogoConfigurable}
     *
     * @return Objeto {@link Catalogo}
     */
    public static Catalogo build(CatalogoConfigurable elemento) {
        return build(Collections.singletonList(elemento));
    }

    /**
     * Crear un objeto {@link Catalogo}
     *
     * @param elementos Elementos del catálogo {@link CatalogoConfigurable}
     *
     * @return Objeto {@link Catalogo}
     */
    public static Catalogo build(List<? extends CatalogoConfigurable> elementos) {
        Catalogo catalogo = getCatalogo(getConfiguracion(elementos));
        catalogo.setElementos(elementos);
        return catalogo;
    }

    /**
     * Crea un objeto Catalogo apartir de la configuración.
     *
     * @param configuracion Configuración del catalogo {@link Configuracion}
     *
     * @return Objeto {@link Catalogo}
     */
    private static Catalogo getCatalogo(Configuracion configuracion) {
        Catalogo catalogo = new Catalogo();

        catalogo.setDominio(configuracion.getDominio());
        catalogo.setTipo(configuracion.getTipo());
        catalogo.setValorDefault(configuracion.getValorDefault());
        catalogo.setDescripcion(configuracion.getDescripcion());
        catalogo.setUltimaActualizacion(configuracion.getUltimaActualizacion());

        return catalogo;
    }

    /**
     * Recupera la configuración del catálogo
     *
     * @param ccs Lista de elementos del catálogo.
     *
     * @return Objeto {@link Configuracion}
     */
    private static Configuracion getConfiguracion(List<? extends CatalogoConfigurable> ccs) {
        return ccs.get(0).getConfiguracion();
    }
}