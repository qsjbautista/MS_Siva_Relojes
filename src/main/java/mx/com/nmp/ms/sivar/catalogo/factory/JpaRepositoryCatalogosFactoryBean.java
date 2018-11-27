

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


import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;


/**
 * Adaotador para crear e inicializar la fabrica de repositorios
 * personalizada, que permite cambiar el JavaType en tiempo de ejecución
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class JpaRepositoryCatalogosFactoryBean<T extends Repository<S, ID>, S, ID>
        extends JpaRepositoryFactoryBean<T, S, ID> {

    /**
     * Tipo de entidad que manejara el repositorio
     */
    private Class<?> entidadType;

    /**
     * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public JpaRepositoryCatalogosFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    /**
     * Regresa la fabrica de repositorios personalizada.
     *
     * {@inheritDoc}
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new JpaRepositoryCatalogosFactory(entityManager, entidadType);
    }

    /**
     * Recupera el valor de {@code entidadType}
     *
     * @return Valor de {@code entidadType}
     */
    public Class<?> getEntidadType() {
        return entidadType;
    }

    /**
     * Establece el valor de {@code entidadType}
     *
     * @param entidadType Valor de {@code entidadType}
     */
    public void setEntidadType(Class<?> entidadType) {
        this.entidadType = entidadType;
    }
}
