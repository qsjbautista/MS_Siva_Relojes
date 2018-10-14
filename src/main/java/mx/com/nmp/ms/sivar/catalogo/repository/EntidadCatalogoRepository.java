

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


import mx.com.nmp.ms.sivar.catalogo.domain.EntidadCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositorio encargado de la comunicación con los dispositivos de
 * persistencia para recuperar al metadata de la relacion catalogo-entidad
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface EntidadCatalogoRepository extends JpaRepository<EntidadCatalogo, Long> {

    /**
     * Busca por el nombre del catalogo la metadata de la relacion catalogo-entidad
     *
     * @param catalogo Catalogo por el cual se buscara
     *
     * @return Entidad buscada, {@literal null} si no existe
     */
    EntidadCatalogo findByCatalogo(String catalogo);
}
