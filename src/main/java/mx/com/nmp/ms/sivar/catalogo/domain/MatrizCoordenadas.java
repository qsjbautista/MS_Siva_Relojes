

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
import java.math.BigDecimal;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;


/**
 * Entidad que representa al catálogo Matriz de Coordenadas
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Cache(usage = NONSTRICT_READ_WRITE)
@Table(name = "cat_matriz_coordenadas")
public class MatrizCoordenadas extends AbstractCatalogo {

    /**
     * Identificador de un registro del catálogo Condiciones generales.
     */
    @Column(name = "condicion", length = 20, nullable = false)
    private String condicion;

    /**
     * Identificador de una entrada del catálogo Desplazamiento comercial.
     */
    @Column(name = "desplazamiento", length = 20, nullable = false)
    private String desplazamiento;

    /**
     * Indica el factor a aplicar para una combinación de los catálogos Condiciones generales y Desplazamiento comercial,
     * para representar una combinación no valida debe ser un valor menor o igual que 0 (cero) o la columna valida como false.
     */
    @Column(name = "factor", precision = 5, scale = 4, nullable = false)
    private BigDecimal factor;

    /**
     * Indica si es una combinación valida, una combinación valida
     * debe tener el valor true y el valor de la columna factor mayor a 0 (cero)
     */
    @Column(name = "valida", nullable = false)
    private Boolean valida;

    /**
     * Constructor de la clase
     */
    public MatrizCoordenadas() {
        super();
    }

    /**
     * Recupera el valor de {@code condicion}
     *
     * @return Valor de {@code condicion}
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * Establece el valor de {@code condicion}
     *
     * @param condicion Valor de {@code condicion}
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    /**
     * Recupera el valor de {@code desplazamiento}
     *
     * @return Valor de {@code desplazamiento}
     */
    public String getDesplazamiento() {
        return desplazamiento;
    }

    /**
     * Establece el valor de {@code desplazamiento}
     *
     * @param desplazamiento Valor de {@code desplazamiento}
     */
    public void setDesplazamiento(String desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    /**
     * Recupera el valor de {@code factor}
     *
     * @return Valor de {@code factor}
     */
    public BigDecimal getFactor() {
        return factor;
    }

    /**
     * Establece el valor de {@code factor}
     *
     * @param factor Valor de {@code factor}
     */
    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    /**
     * Recupera el valor de {@code valida}
     *
     * @return Valor de {@code valida}
     */
    public Boolean getValida() {
        return valida;
    }

    /**
     * Establece el valor de {@code valida}
     *
     * @param valida Valor de {@code valida}
     */
    public void setValida(Boolean valida) {
        this.valida = valida;
    }

    @Override
    public String toString() {
        return "MatrizCoordenadas{" +
                "abreviatura='" + getAbreviatura() + '\'' +
                ", condicion='" + condicion + '\'' +
                ", desplazamiento='" + desplazamiento + '\'' +
                ", factor=" + factor +
                ", valida=" + valida +
                '}';
    }
}
