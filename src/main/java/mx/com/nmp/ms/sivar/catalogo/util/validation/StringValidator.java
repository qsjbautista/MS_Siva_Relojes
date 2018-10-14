

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


package mx.com.nmp.ms.sivar.catalogo.util.validation;


import mx.com.nmp.ms.sivar.catalogo.exception.BadRequestException;
import org.springframework.util.StringUtils;

import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_0001;


/**
 * Utileria que permita la validacion de cadenas de texto
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public final class StringValidator {

    /**
     * Constructor de la clase, Privado ya que no se debe instannciar.
     */
    private StringValidator() {
        super();
    }

    /**
     * Valida que una cadena de texto contenga por lo menos un caracter imprimible
     *
     * @param string Cadena a validar
     * @param message Mensaje si la validacion falla
     */
    public static void hasText(String string, String message) {
        if (!StringUtils.hasText(string)) {
            throw new BadRequestException(NMP_SRC_0001, message, message);
        }
    }
}
