

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


import mx.com.nmp.ms.sivar.catalogo.domain.MatrizCoordenadas;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositorio encargado de la comunicación con los dispositivos
 * de persistencia para manejar el catálogo matriz de coordenadas.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface MatrizCoordenadasRepository extends JpaRepository<MatrizCoordenadas, Long> {

    /**
     * Método que se encarga de recuperar un elemento del catálogo
     * matriz de coordenadas, donde la condición y desplazamiento sean iguales a las capturadas
     *
     * @param condicion Nombre del elemento del catálogo condiciones generales
     * @param desplazamiento Nombre del elemento del catálogo desplazamiento comercial
     *
     * @return Elemento del catalogo, {@literal null} si no existe
     */
    MatrizCoordenadas findByCondicionAndDesplazamiento(String condicion, String desplazamiento);
}
