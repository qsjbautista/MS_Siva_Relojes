

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


package mx.com.nmp.ms.sivar.catalogo.domain;


import org.hibernate.annotations.Cache;

import javax.persistence.Entity;
import javax.persistence.Table;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;


/**
 * Entidad que representa al catálogo Condiciones Generales
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Cache(usage = NONSTRICT_READ_WRITE)
@Table(name = "cat_condiciones_generales")
public class CondicionesGenerales extends AbstractCatalogo {

    /**
     * Constructor de la clase
     */
    public CondicionesGenerales() {
        super();
    }
}
