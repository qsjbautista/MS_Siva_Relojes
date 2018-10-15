

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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;


/**
 * Entidad que representa al catálogo Refrendo
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Table(name = "cat_refrendo")
@Cache(usage = NONSTRICT_READ_WRITE)
public class Refrendo extends AbstractCatalogo {
    /**
     * Identificador de un registro del catálogo Tipo Reloj.
     */
    @Column(name = "tipo_reloj", length = 20, nullable = false)
    private String tipoReloj;

    /**
     * Numero de refrendos segun el tipo reloj
     */
    @Column(name = "numero", nullable = false)
    private Integer numero;

    /**
     * Constrcutor de la clase
     */
    public Refrendo() {
        super();
    }

    /**
     * Recupera el valor de {@code tipoReloj}
     *
     * @return Valor de {@code tipoReloj}
     */
    public String getTipoReloj() {
        return tipoReloj;
    }

    /**
     * Establece el valor de {@code tipoReloj}
     *
     * @param tipoReloj Valor de {@code tipoReloj}
     */
    public void setTipoReloj(String tipoReloj) {
        this.tipoReloj = tipoReloj;
    }

    /**
     * Recupera el valor de {@code numero}
     *
     * @return Valor de {@code numero}
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Establece el valor de {@code numero}
     *
     * @param numero Valor de {@code numero}
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
