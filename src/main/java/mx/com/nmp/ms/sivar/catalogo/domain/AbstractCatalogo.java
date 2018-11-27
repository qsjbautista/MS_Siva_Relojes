

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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.sivar.catalogo.dto.CatalogoConfigurable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * Clase abstracta representa las propiedades comunes de un catalogo
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@MappedSuperclass
@JsonIgnoreProperties({"idElemento", "configuracion"})
public abstract class AbstractCatalogo implements CatalogoConfigurable {
    /**
     * Identificar interno del registro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_elemento", nullable = false)
    private Long idElemento;

    /**
     * Identificador del registro orientado al uso en otros sistemas
     */
    @Column(name = "abreviatura", nullable = false, length = 20, unique = true)
    private String abreviatura;

    /**
     * Identifica el valor de la entrada a mostrar para efectos de visualización del catálogo
     */
    @Column(name = "etiqueta", nullable = false)
    private String etiqueta;

    /**
     * Identifica el registro asociado de metadata del catálogo. Este contiene la definición del catálogo en sí
     */
    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private Configuracion configuracion;

    /**
     * Constructor de la clase
     */
    public AbstractCatalogo() {
        super();
    }

    /**
     * Recupera el valor de {@code idElemento}
     *
     * @return Valor de {@code idElemento}
     */
    public Long getIdElemento() {
        return idElemento;
    }

    /**
     * Establece el valor de {@code idElemento}
     *
     * @param idElemento Valor de {@code idElemento}
     */
    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * Recupera el valor de {@code abreviatura}
     *
     * @return Valor de {@code abreviatura}
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Establece el valor de {@code abreviatura}
     *
     * @param abreviatura Valor de {@code abreviatura}
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Recupera el valor de {@code etiqueta}
     *
     * @return Valor de {@code etiqueta}
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Establece el valor de {@code etiqueta}
     *
     * @param etiqueta Valor de {@code etiqueta}
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Recupera el valor de {@code configuracion}
     *
     * @return Valor de {@code configuracion}
     */
    @Override
    public Configuracion getConfiguracion() {
        return configuracion;
    }

    /**
     * Establece el valor de {@code configuracion}
     *
     * @param configuracion Valor de {@code configuracion}
     */
    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }
}
