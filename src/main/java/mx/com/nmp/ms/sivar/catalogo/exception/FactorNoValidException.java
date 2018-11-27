

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


import mx.com.nmp.ms.sivar.catalogo.constans.CodigoError;


/**
 * Excepción que será lanzada cuando la combinación de matriz de coordenadas no es valida
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class FactorNoValidException extends AbstractCatalogoException {
    /**
     * Constructor de la clase
     *
     * @param codigoError      Código del error.
     * @param descripcionError Descripción del error.
     * @param message          Información adicional sobre la excepción
     */
    public FactorNoValidException(CodigoError codigoError, String descripcionError, String message) {
        super(codigoError, descripcionError, message);
    }
}
