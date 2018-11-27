

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
 * Excepción que será lanzada cuando no se encuentre la entidad buscada
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class NotFoundException extends AbstractCatalogoException {
    /**
     * Constructor de la clase
     *
     * @param codigoError      Código del error.
     * @param descripcionError Descripción del error.
     * @param message          Información adicional sobre la excepción
     */
    public NotFoundException(CodigoError codigoError, String descripcionError, String message) {
        super(codigoError, descripcionError, message);
    }
}
