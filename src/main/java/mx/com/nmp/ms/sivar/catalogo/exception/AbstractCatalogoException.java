

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


package mx.com.nmp.ms.sivar.catalogo.exception;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.sivar.catalogo.constans.CodigoError;


/**
 * Excepción que encapsula la información general para las excepciones que serán lanzadas
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@JsonIgnoreProperties({"localizedMessage", "stackTrace", "suppressed", "cause"})
public class AbstractCatalogoException extends RuntimeException {

    /**
     * Código del error.
     */
    private CodigoError codigoError;

    /**
     * Descripción del error.
     */
    private String descripcionError;

    /**
     * Constructor de la clase
     *
     * @param codigoError Código del error.
     * @param descripcionError Descripción del error.
     * @param message Información adicional sobre la excepción
     */
    public AbstractCatalogoException(CodigoError codigoError, String descripcionError, String message) {
        super(message);

        this.codigoError = codigoError;
        this.descripcionError = descripcionError;
    }

    /**
     * Recupera el valor de {@code codigoError}
     *
     * @return Valor de {@code codigoError}
     */
    public CodigoError getCodigoError() {
        return codigoError;
    }

    /**
     * Recupera el valor de {@code descripcionError}
     *
     * @return Valor de {@code descripcionError}
     */
    public String getDescripcionError() {
        return descripcionError;
    }
}
