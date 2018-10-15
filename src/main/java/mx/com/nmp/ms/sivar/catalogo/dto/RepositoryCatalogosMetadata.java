

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


package mx.com.nmp.ms.sivar.catalogo.dto;


import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.core.RepositoryMetadata;

import java.lang.reflect.Method;
import java.util.Set;


/**
 * Objeto dto sive como fachada para lograr cambiar en tiempo de ejecución el tipo de entidad de un repositorio
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class RepositoryCatalogosMetadata implements RepositoryMetadata {

    /**
     * Entidad que manejara el repositorio
     */
    private final Class<?> domainType;

    /**
     * Metadata original
     */
    private final RepositoryMetadata original;

    /**
     * Constructor de la clase
     *
     * @param domainType Entidad que manejara el repositorio
     * @param original Metadata original
     */
    public RepositoryCatalogosMetadata(Class<?> domainType, RepositoryMetadata original) {
        super();

        this.domainType = domainType;
        this.original = original;
    }

    /**
     * Recupera el valor de {@code idType}
     *
     * @return Valor de {@code idType}
     */
    @Override
    public Class<?> getIdType() {
        return original.getIdType();
    }

    /**
     * Recupera el valor de {@code domainType}
     *
     * @return Valor de {@code domainType}
     */
    @Override
    public Class<?> getDomainType() {
        return domainType;
    }

    /**
     * Recupera el valor de {@code repositoryInterface}
     *
     * @return Valor de {@code repositoryInterface}
     */
    @Override
    public Class<?> getRepositoryInterface() {
        return original.getRepositoryInterface();
    }

    /**
     * Recupera el valor de {@code returnedDomainClass}
     *
     * @return Valor de {@code returnedDomainClass}
     */
    @Override
    public Class<?> getReturnedDomainClass(Method method) {
        return original.getReturnedDomainClass(method);
    }

    /**
     * Recupera el valor de {@code crudMethods}
     *
     * @return Valor de {@code crudMethods}
     */
    @Override
    public CrudMethods getCrudMethods() {
        return original.getCrudMethods();
    }

    /**
     * Recupera el valor de {@code pagingRepository}
     *
     * @return Valor de {@code pagingRepository}
     */
    @Override
    public boolean isPagingRepository() {
        return original.isPagingRepository();
    }

    /**
     * Recupera el valor de {@code alternativeDomainTypes}
     *
     * @return Valor de {@code alternativeDomainTypes}
     */
    @Override
    public Set<Class<?>> getAlternativeDomainTypes() {
        return original.getAlternativeDomainTypes();
    }

    /**
     * Recupera el valor de {@code reactiveRepository}
     *
     * @return Valor de {@code reactiveRepository}
     */
    @Override
    public boolean isReactiveRepository() {
        return original.isReactiveRepository();
    }
}
