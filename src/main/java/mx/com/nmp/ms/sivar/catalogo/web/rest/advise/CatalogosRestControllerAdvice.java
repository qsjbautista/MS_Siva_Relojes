

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


package mx.com.nmp.ms.sivar.catalogo.web.rest.advise;


import mx.com.nmp.ms.sivar.catalogo.exception.BadRequestException;
import mx.com.nmp.ms.sivar.catalogo.exception.FactorNoValidException;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;


/**
 * Manejador global de excepciones, se encarga de manejar las excepciones
 * lanzadas en las clases anotadas con {@link org.springframework.web.bind.annotation.RestController}}
 * @see mx.com.nmp.ms.sivar.catalogo.web.rest
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestControllerAdvice
public class CatalogosRestControllerAdvice {

    /**
     * Metodo que procesa excepciones y regresa un estado {@link HttpStatus#BAD_REQUEST}
     *
     * @param e Excepción con información del error
     *
     * @return Información referente al error que produce la excepción
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public BadRequestException manejarExcepcionBadRequest(BadRequestException e) {
        return e;
    }

    /**
     * Metodo que procesa excepciones y regresa un estado {@link HttpStatus#FORBIDDEN}
     *
     * @param e Excepción con información del error
     *
     * @return Información referente al error que produce la excepción
     */
    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(FactorNoValidException.class)
    public FactorNoValidException manejarExcepcionFactorNoValid(FactorNoValidException e) {
        return e;
    }

    /**
     * Metodo que procesa excepciones y regresa un estado {@link HttpStatus#NOT_FOUND}
     *
     * @param e Excepción con información del error
     *
     * @return Información referente al error que produce la excepción
     */
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public NotFoundException manejarExcepcionNotFound(NotFoundException e) {
        return e;
    }

    /**
     * Metodo que procesa excepciones y regresa un estado {@link HttpStatus#INTERNAL_SERVER_ERROR}
     *
     * @param e Excepción con información del error
     *
     * @return Información referente al error que produce la excepción
     */
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public InternalServerErrorException manejarExcepcionInternalServerError(InternalServerErrorException e) {
        return e;
    }
}
