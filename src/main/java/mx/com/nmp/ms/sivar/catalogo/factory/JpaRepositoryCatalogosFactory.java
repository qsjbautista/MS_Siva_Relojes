

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


package mx.com.nmp.ms.sivar.catalogo.factory;

import mx.com.nmp.ms.sivar.catalogo.dto.RepositoryCatalogosMetadata;
import mx.com.nmp.ms.sivar.catalogo.repository.CatalogosRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;


/**
 * Fabrica que se encarga de construir repositorios Spring data jpa en tiempo de
 * ejecución, permitiendo cambiar el JavaType establecido al momento de desplegar la aplicación
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class JpaRepositoryCatalogosFactory extends JpaRepositoryFactory {

    /**
     * Tipo de entidad que manejara el repositorio
     */
    private Class<?> entidadType;

    /**
     * Creates a new {@link JpaRepositoryFactory}.
     *
     * @param entityManager must not be {@literal null}
     * @param entidadType Tipo de entidad que manejara el repositorio
     */
    public JpaRepositoryCatalogosFactory(EntityManager entityManager, Class<?> entidadType) {
        super(entityManager);

        this.entidadType = entidadType;
    }

    /**
     * Regresa la metadata del repositorio según su interfaz y la entidad que desea consultar
     *
     * {@inheritDoc}
     */
    @Override
    protected RepositoryMetadata getRepositoryMetadata(Class<?> repositoryInterface) {
        RepositoryMetadata rm = super.getRepositoryMetadata(repositoryInterface);

        if (CatalogosRepository.class.isAssignableFrom(repositoryInterface)) {
            /*
             * Si es un repositorio de catalogos se cambia el tipo de entidad y se regresa metadata personalizado
             */
            return new RepositoryCatalogosMetadata(entidadType, rm);
        } else {
            return rm;
        }
    }

}
