

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;


/**
 * Represnta la metadata de la relación catálogo-entidad
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Cache(usage = NONSTRICT_READ_WRITE)
@Table(name = "cnf_entidad_catalogo")
public class EntidadCatalogo {
    /**
     * Identificador único del registro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Nombre del catálogo orientado a otros sistemas. Debe ser un nombre en singular,
     * en letras mayúsculas y usar el símbolo ‘_’ como separador de palabras. Ejemplo: TIPO_RELOJ.
     */
    @Column(name = "catalogo", nullable = false, length = 100)
    private String catalogo;

    /**
     * Nombre de la entidad que maneja el catálogo. Debe ser el nombre
     * completo de la entidad. Ejemplo: mx.com.nmp.ms.sivar.catalogo.domain.TipoReloj
     */
    @Column(name = "entidad", nullable = false, length = 100)
    private Class<?> entidad;

    /**
     * Constructor de la clase
     */
    public EntidadCatalogo() {
        super();
    }

    /**
     * Recupera el valor de {@code id}
     *
     * @return Valor de {@code id}
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor de {@code id}
     *
     * @param id Valor de {@code id}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Recupera el valor de {@code catalogo}
     *
     * @return Valor de {@code catalogo}
     */
    public String getCatalogo() {
        return catalogo;
    }

    /**
     * Establece el valor de {@code catalogo}
     *
     * @param catalogo Valor de {@code catalogo}
     */
    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * Recupera el valor de {@code entidad}
     *
     * @return Valor de {@code entidad}
     */
    public Class<?> getEntidad() {
        return entidad;
    }

    /**
     * Establece el valor de {@code entidad}
     *
     * @param entidad Valor de {@code entidad}
     */
    public void setEntidad(Class<?> entidad) {
        this.entidad = entidad;
    }
}
