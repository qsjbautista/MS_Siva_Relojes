

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


package mx.com.nmp.ms.sivar.catalogo.constans;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Enumeración que enlista los tipo de errores
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public enum TipoError {

    /**
     * Error por parte del cliente
     */
    CLIENTE("Error del Cliente"),

    /**
     * Error por parte del servidor
     */
    SERVIDOR("Error del Servidor");

    /**
     * Cadena que indica el tipo de error
     */
    private String tipo;

    /**
     * Constructor
     *
     * @param tipo Cadena que indica el tipo de error
     */
    TipoError(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Recupera el valor de {@code tipo}
     *
     * @return Valor de {@code tipo}
     */
    @JsonValue
    public String getTipo() {
        return tipo;
    }
}
