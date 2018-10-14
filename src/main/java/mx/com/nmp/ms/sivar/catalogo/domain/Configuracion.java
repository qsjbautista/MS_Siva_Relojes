

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
import java.time.LocalDateTime;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;


/**
 * Clase abstracta representa las propiedades comunes de un catalogo
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Cache(usage = NONSTRICT_READ_WRITE)
@Table(name = "cnf_configuracion_catalogo")
public class Configuracion {
    /**
     * Identificador único de la configuración de un catálogo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Nombre del dominio al cual pertenece el catálogo. Debe ser un nombre en singular con estándar CamelCase
     */
    @Column(name = "dominio", length = 100, nullable = false)
    private String dominio;

    /**
     * Identifica el tipo de catálogo representado. Debe ser un nombre en singular con estándar CamelCase
     */
    @Column(name = "tipo", length = 100, nullable = false)
    private String tipo;

    /**
     * Descripción del propósito del catálogo o provee información adicional para su utilización
     */
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    /**
     * Fecha de la última actualización del catálogo
     */
    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    /**
     * Representa el valor por defecto dentro de un catálogo específico.
     * Esta propiedad puede ser usada por los servicios que hagan uso del catálogo
     */
    @Column(name = "valor_default", length = 20)
    private String valorDefault;

    /**
     * Constructor de la clase
     */
    public Configuracion() {
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
     * Recupera el valor de {@code dominio}
     *
     * @return Valor de {@code dominio}
     */
    public String getDominio() {
        return dominio;
    }

    /**
     * Establece el valor de {@code dominio}
     *
     * @param dominio Valor de {@code dominio}
     */
    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    /**
     * Recupera el valor de {@code tipo}
     *
     * @return Valor de {@code tipo}
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el valor de {@code tipo}
     *
     * @param tipo Valor de {@code tipo}
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Recupera el valor de {@code descripcion}
     *
     * @return Valor de {@code descripcion}
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece el valor de {@code descripcion}
     *
     * @param descripcion Valor de {@code descripcion}
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Recupera el valor de {@code ultimaActualizacion}
     *
     * @return Valor de {@code ultimaActualizacion}
     */
    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    /**
     * Establece el valor de {@code ultimaActualizacion}
     *
     * @param ultimaActualizacion Valor de {@code ultimaActualizacion}
     */
    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    /**
     * Recupera el valor de {@code valorDefault}
     *
     * @return Valor de {@code valorDefault}
     */
    public String getValorDefault() {
        return valorDefault;
    }

    /**
     * Establece el valor de {@code valorDefault}
     *
     * @param valorDefault Valor de {@code valorDefault}
     */
    public void setValorDefault(String valorDefault) {
        this.valorDefault = valorDefault;
    }
}
