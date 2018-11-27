

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


import mx.com.nmp.ms.sivar.catalogo.domain.Refrendo;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import mx.com.nmp.ms.sivar.catalogo.repository.RefrendoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_0002;
import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_9999;
import static mx.com.nmp.ms.sivar.catalogo.util.validation.StringValidator.hasText;

/**
 * Servicio que brinda las funciones necesarias para administrar1 el catálogo refrendos
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
public class RefrendoService {
    // Pemirte escribir en la vitacora del sistema
    private static final Logger LOGGER = LoggerFactory.getLogger(RefrendoService.class);

    /**
     * Referenica al repositorio de refrendos
     */
    @Autowired
    private RefrendoRepository refrendoRepository;

    /**
     * Constrcutor de la clase
     */
    public RefrendoService() {
        super();
    }

    public Refrendo recuperarElemento(String tipoReloj) {
        LOGGER.trace(">> recuperarElemento() > parametros {}, {}", tipoReloj);

        hasText(tipoReloj, "El valor del parametro 'tipoReloj' no es valido");

        Refrendo entrada;

        try {
            entrada = refrendoRepository.findByTipoReloj(tipoReloj);
        } catch (Exception e) {
            String des = String.format("Ocurrio un error al recuperar el refrendo " +
                    "para el tipo reloj: %s", tipoReloj);
            LOGGER.error(des, e);
            throw new InternalServerErrorException(NMP_SRC_9999, des, e.getMessage());
        }

        if (entrada == null) {
            String des = String.format("No se encontro el refrendo " +
                    "para el tipo reloj: %s", tipoReloj);
            LOGGER.warn(des);
            throw new NotFoundException(NMP_SRC_0002, des, des);
        }

        LOGGER.trace("<< recuperarElemento() < retorno {}", entrada);

        return entrada;
    }
}
