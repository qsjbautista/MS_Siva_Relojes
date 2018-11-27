

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


package mx.com.nmp.ms.sivar.catalogo.service;


import mx.com.nmp.ms.sivar.catalogo.domain.MatrizCoordenadas;
import mx.com.nmp.ms.sivar.catalogo.exception.BadRequestException;
import mx.com.nmp.ms.sivar.catalogo.exception.FactorNoValidException;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import mx.com.nmp.ms.sivar.catalogo.repository.MatrizCoordenadasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_0002;
import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_0004;
import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_9999;
import static mx.com.nmp.ms.sivar.catalogo.util.validation.StringValidator.hasText;


/**
 * Servicio que brinda las funciones necesarias para administrar1 el catálogo matriz de coordenadas.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
public class MatrizCoordenadasService {

    // Pemirte escribir en la vitacora del sistema
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrizCoordenadasService.class);

    /**
     * Referenica al repositorio de matriz de coordenadas
     */
    @Autowired
    private MatrizCoordenadasRepository matrizCoordenadasRepository;

    /**
     * Constrcutor de la clase
     */
    public MatrizCoordenadasService() {
        super();
    }

    /**
     * Método que se encarga de recuperar un elemento del catálogo matriz de coordenadas.
     *
     * @param condicion Nombre del elemento del catálogo condiciones generales
     * @param desplazamiento Nombre del elemento del catálogo desplazamiento comercial
     *
     * @return Elemento de la matriz
     *
     * @throws BadRequestException Si alguno de los parametros no es correcto
     * @throws NotFoundException Si no se encuentra el elemento buscado.
     * @throws FactorNoValidException Si elemento representa una cmbianción no valida {@link MatrizCoordenadas#valida}
     * @throws InternalServerErrorException Si ocurre un error no esperado.
     */
    public MatrizCoordenadas recuperarElemento(String condicion, String desplazamiento) {
        LOGGER.trace(">> recuperarElemento() > parametros {}, {}", condicion, desplazamiento);

        hasText(condicion, "El valor del parametro 'condicion' no es valido");
        hasText(desplazamiento, "El valor del parametro 'desplazamiento' no es valido");

        MatrizCoordenadas entrada;

        try {
            entrada = matrizCoordenadasRepository.findByCondicionAndDesplazamiento(condicion, desplazamiento);
        } catch (Exception e) {
            String des = String.format("Ocurrio un error al recuperar el factor " +
                    "para la combinación, Condicion: %s,  Desplazamiento: %s", condicion, desplazamiento);
            LOGGER.error(des, e);
            throw new InternalServerErrorException(NMP_SRC_9999, des, e.getMessage());
        }

        if (entrada == null) {
            String des = String.format("No se encontro el factor " +
                    "para la combinación, Condicion: %s,  Desplazamiento: %s", condicion, desplazamiento);
            String msj = String.format("No se encontro la combinación, " +
                    "Condicion: %s,  Desplazamiento: %s, en la tabla cat_matriz_coordenadas", condicion, desplazamiento);
            LOGGER.warn(msj);
            throw new NotFoundException(NMP_SRC_0002, des, msj);
        }

        if (!entrada.getValida() || entrada.getFactor().compareTo(BigDecimal.ZERO) <= 0) {
            String des = String.format(
                    "La combinación, Condicion: %s,  Desplazamiento: %s, no es valida", condicion, desplazamiento);
            String msj = String.format("La combinacion no es valida: %s", entrada);
            LOGGER.info(msj);
            throw new FactorNoValidException(NMP_SRC_0004, des, msj);
        }

        LOGGER.trace("<< recuperarElemento() < retorno {}", entrada);

        return entrada;
    }
}
