

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


import mx.com.nmp.ms.sivar.catalogo.domain.AbstractCatalogo;
import mx.com.nmp.ms.sivar.catalogo.exception.AbstractCatalogoException;
import mx.com.nmp.ms.sivar.catalogo.exception.BadRequestException;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_0002;
import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_9999;
import static mx.com.nmp.ms.sivar.catalogo.util.validation.StringValidator.hasText;


/**
 * Servicio que brinda las funciones necesarias para administrar los catálogos:
 * <ul>
 *     <li>Marca</li>
 *     <li>Tipo Reloj</li>
 *     <li>Género</li>
 *     <li>Condiciones generales</li>
 *     <li>Desplazamiento comercial</li>
 * </ul>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
public class CatalogosService {

    // Pemirte escribir en la vitacora del sistema
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosService.class);

    /**
     * Referencia al repositorio de catalogos
     */
    @Autowired
    private CatalogosRepositoryManager catalogosRepositoryManager;

    /**
     * Constrcutor de la clase
     */
    public CatalogosService() {
        super();
    }

    /**
     * Método que se encarga de recuperar un elemento del catálogo especificado.
     *
     * @param catalogo Nombre del catálogo a recuperar
     * @param elemento Nombre del elemento a recuperar
     *
     * @return Elemento del catálogo buscado
     *
     * @throws BadRequestException Si alguno de los parametros no es correcto
     * @throws NotFoundException Si no se encuentra el elemento no existe.
     *                           Si el catálogo no existe o no esta configurado.
     * @throws InternalServerErrorException Si ocurre un error no esperado.
     */
    public AbstractCatalogo recuperarElemento(String catalogo, String elemento) {
        LOGGER.trace(">> recuperarElemento() > parametros {}, {}", catalogo, elemento);

        hasText(catalogo, "El valor del parametro 'catalogo' no es valido");
        hasText(elemento, "El valor del parametro 'elemento' no es valido");

        AbstractCatalogo entrada;

        try {
            entrada = catalogosRepositoryManager.recuperarRepositorio(catalogo).findByAbreviatura(elemento);
        } catch (AbstractCatalogoException e) {
            throw e;
        } catch (Exception e) {
            String des = String.format(
                    "Ocurrio un error al recuperar el elemento %s, del catálogo %s", elemento, catalogo);
            LOGGER.error(des, e);
            throw new InternalServerErrorException(NMP_SRC_9999, des, e.getMessage());
        }

        if (entrada == null) {
            String des = String.format("El elemento %s, del catálogo %s, no existe", elemento, catalogo);
            LOGGER.warn(des);
            throw new NotFoundException(NMP_SRC_0002, des, des);
        }

        LOGGER.trace("<< recuperarElemento() < retorno {}", entrada);

        return entrada;
    }

    /**
     * Método que se encarga de recuperar todos los elementos del catálogo especificado
     *
     * @param catalogo Nombre del catálogo a recuperar
     *
     * @return Elementos del catálogo buscado
     *
     * @throws BadRequestException Si alguno de los parametros no es correcto
     * @throws NotFoundException Si el catálogo no existe o no esta configurado.
     * @throws InternalServerErrorException Si ocurre un error no esperado.
     */
    @SuppressWarnings("unchecked")
    public List<? extends AbstractCatalogo> recuperar(String catalogo) {
        LOGGER.trace(">> recuperar() > parametros {}", catalogo);

        hasText(catalogo, "El valor del parametro 'catalogo' no es valido");

        List<? extends AbstractCatalogo> entradas;

        try {
            entradas = catalogosRepositoryManager.recuperarRepositorio(catalogo).findAll();
        } catch (AbstractCatalogoException e) {
            throw e;
        } catch (Exception e) {
            String des = String.format(
                    "Ocurrio un error al recuperar los elemento del catálogo %s", catalogo);
            LOGGER.error(des, e);
            throw new InternalServerErrorException(NMP_SRC_9999, des, e.getMessage());
        }

        LOGGER.trace("<< recuperar() < retorno {}", entradas);

        return entradas;
    }

    /**
     * Método que se encarga de buscar (de manera predictiva) los
     * elementos del catálogo especificado donde la etiqueta contenga el valor indicado.
     *
     * @param catalogo Nombre del catálogo a recuperar
     * @param valor Valor que se espera coinciada con una o parde un etiqueta de un elemento del catálogo
     *
     * @return Elementos del catalogo buscado
     *
     * @throws BadRequestException Si alguno de los parametros no es correcto
     * @throws NotFoundException Si el catálogo no existe o no esta configurado.
     * @throws InternalServerErrorException Si ocurre un error no esperado.
     */
    public List<? extends AbstractCatalogo> autocompletar(String catalogo, String valor) {
        LOGGER.trace(">> autocompletar() > parametros {}, {}", catalogo, valor);

        hasText(catalogo, "El valor del parametro 'catalogo' no es valido");
        hasText(valor, "El valor del parametro 'valor' no es valido");

        List<? extends AbstractCatalogo> entradas;

        try {
            entradas = catalogosRepositoryManager.recuperarRepositorio(catalogo).findByEtiquetaContaining(valor);
        } catch (AbstractCatalogoException e) {
            throw e;
        } catch (Exception e) {
            String des = String.format(
                    "Ocurrio un error al realizar la busqueda predictiva por %s, del catálogo %s", valor, catalogo);
            LOGGER.error(des, e);
            throw new InternalServerErrorException(NMP_SRC_9999, des, e.getMessage());
        }

        LOGGER.trace("<< autocompletar() < retorno {}", entradas);

        return entradas;
    }
}
