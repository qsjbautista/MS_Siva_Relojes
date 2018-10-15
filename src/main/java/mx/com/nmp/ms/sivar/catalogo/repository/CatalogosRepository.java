

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


package mx.com.nmp.ms.sivar.catalogo.repository;


import mx.com.nmp.ms.sivar.catalogo.domain.AbstractCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Repositorio encargado de la comunicación con los dispositivos de persistencia para manejar los catálogos:
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
@NoRepositoryBean
public interface CatalogosRepository<T extends AbstractCatalogo> extends JpaRepository<T, Long> {

    /**
     * Método que se encarga de recuperar todos los elementos del catálogo especificado, donde la etiqueta contenga el valor especificado
     *
     * @param etiqueta Etiqueta o fracción para realizar la busqueda
     *
     * @return Lista de elementos encontrados, vacio si no existen
     */
    List<T> findByEtiquetaContaining(@Param("etiqueta") String etiqueta);

    /**
     * Método que se encarga de recuperar el elemento del catálogo especificado, que coincida con la abreviatura indicada
     *
     * @param abreviatura Abreviatura del elemento a buscar
     *
     * @return Elemento encontrado, {@literal null} si no existe
     */
    T findByAbreviatura(String abreviatura);
}
