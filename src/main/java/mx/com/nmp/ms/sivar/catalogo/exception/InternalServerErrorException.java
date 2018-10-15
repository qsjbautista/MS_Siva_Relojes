

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
 * Excepción que será lanzada cuando ocurra un error no esperado
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class InternalServerErrorException extends AbstractCatalogoException {
    /**
     * Constructor de la clase
     *
     * @param codigoError      Código del error.
     * @param descripcionError Descripción del error.
     * @param message          Información adicional sobre la excepción
     */
    public InternalServerErrorException(CodigoError codigoError, String descripcionError, String message) {
        super(codigoError, descripcionError, message);
    }
}
