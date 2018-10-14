

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


import mx.com.nmp.ms.sivar.catalogo.domain.Refrendo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositorio encargado de la comunicación con los dispositivos
 * de persistencia para manejar el catálogo refrendos.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface RefrendoRepository extends JpaRepository<Refrendo, Long> {

    /**
     * Método que se encarga de recuperar un elemento del catálogo refrendos, donde el tipo reloj sea igual al capturado
     *
     * @param tipoReloj Identificador del elemento del catalogo tipo reloj
     *
     * @return Elemento del catalogo, {@literal null} si no existe
     */
    Refrendo findByTipoReloj(String tipoReloj);
}
