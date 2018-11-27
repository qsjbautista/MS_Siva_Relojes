

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
import mx.com.nmp.ms.sivar.catalogo.domain.EntidadCatalogo;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import mx.com.nmp.ms.sivar.catalogo.factory.JpaRepositoryCatalogosFactoryBean;
import mx.com.nmp.ms.sivar.catalogo.repository.CatalogosRepository;
import mx.com.nmp.ms.sivar.catalogo.repository.EntidadCatalogoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_0003;
import static mx.com.nmp.ms.sivar.catalogo.constans.CodigoError.NMP_SRC_9999;


/**
 * Se encargara de proover del repositorio adecuado segun la entidad a consultar
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
public class CatalogosRepositoryManager {

    // Pemirte escribir en la vitacora del sistema
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosRepositoryManager.class);

    /**
     * Referencia al contexto
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Referencia al repositorio de catálogos
     */
    @Autowired
    private EntidadCatalogoRepository entidadCatalogoRepository;

    private Map<Class<?>, CatalogosRepository<? extends AbstractCatalogo>> repositoryLocalCache;

    /**
     * Bloque para que solo se registre 1 repositoria a la vez
     */
    private final Object lock;

    /**
     * Constructor de la clase
     */
    public CatalogosRepositoryManager() {
        super();

        lock = new Object();
        repositoryLocalCache = new ConcurrentHashMap<>();
    }

    /**
     * Recupera el repositorio para el catálogo indicado por {@code catalogo}
     *
     * @param catalogo Catalgo a concultar
     *
     * @return El repositorio solicitado
     *
     * @throws NotFoundException Si el catátalogo no esta relacionado a alguna entidad
     * @throws InternalServerErrorException Si ocurre un error no esperado
     */
    @SuppressWarnings("unchecked")
    public CatalogosRepository<? extends AbstractCatalogo> recuperarRepositorio(String catalogo) {
        EntidadCatalogo entidadCatalogo = recuperarEntidadCatalogo(catalogo);
        Class<?> entidad = entidadCatalogo.getEntidad();
        String beanName = "catalogo" + entidad.getSimpleName() + "Repository";

        if (!repositoryLocalCache.containsKey(entidad)) {
            synchronized(lock) {
                if (repositoryLocalCache.containsKey(entidad)) {
                    return repositoryLocalCache.get(entidad);
                }

                LOGGER.info("No se encontro el repositorio {}, para la entidad {}, se procede a registrar y crear",
                        beanName, entidad);

                registrarRepositorio(beanName, entidad);
                LOGGER.info("Se registro el repositorio {}, para la entidad {}", beanName, entidad);

                CatalogosRepository<? extends AbstractCatalogo> repository;

                try {
                    repository = applicationContext.getBean(beanName, CatalogosRepository.class);
                    LOGGER.info("Se creo y recupero el repositorio {}, para la entidad {}, {}",
                            beanName, entidad, repository);
                } catch (Exception e) {
                    String des = String.format(
                            "Ocurrio un erroral crear y recuperar el repositorio %s para la entidad %s", beanName, entidad);
                    LOGGER.error(des, e);
                    throw new InternalServerErrorException(NMP_SRC_9999, des, e.getMessage());
                }

                repositoryLocalCache.put(entidad, repository);
            }
        }

        return repositoryLocalCache.get(entidad);
    }

    /**
     * Recupera el metadata de la relacion entre catalogo entidad
     *
     * @param catalogo Catalogo que manejara el repositorio
     *
     * @return {@link EntidadCatalogo} buscado
     *
     * @throws NotFoundException Si el catátalogo no esta relacionado a alguna entidad
     * @throws InternalServerErrorException Si ocurre un error no esperado
     */
    private EntidadCatalogo recuperarEntidadCatalogo(String catalogo) {
        LOGGER.trace(">> recuperarEntidadCatalogo() > parametros {}", catalogo);

        EntidadCatalogo entidadCatalogo;

        try {
            entidadCatalogo = entidadCatalogoRepository.findByCatalogo(catalogo);
        } catch (Exception e) {
            String des = String.format(
                    "Ocurrio un error al recuperar la relacion catálogo-entidad del catálogo %s", catalogo);
            LOGGER.error(des, e);
            throw new InternalServerErrorException(NMP_SRC_9999, des, e.getMessage());
        }

        if (entidadCatalogo == null) {
            String des = String.format("El catálogo %s, no esta configurado", catalogo);
            String msj = String.format("No se encontro el catálogo %s, en la tabla cnf_entidad_catalogo", catalogo);
            throw new NotFoundException(NMP_SRC_0003, des, msj);
        }

        LOGGER.trace("<< recuperarEntidadCatalogo() < retorno {}", entidadCatalogo);

        return entidadCatalogo;
    }

    /**
     * Se encarga de registrar el repositorio para la entidad indicada por {@code classBean}
     *
     * @param beanName Nombre del repositorio
     * @param classBean Tipo del repositorio
     */
    private void registrarRepositorio(String beanName, Class<?> classBean) {
        DefaultListableBeanFactory factory =
                (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        RootBeanDefinition bd = (RootBeanDefinition) factory.getBeanDefinition("entidadCatalogoRepository");

        bd.setBeanClassName(JpaRepositoryCatalogosFactoryBean.class.getName());

        ConstructorArgumentValues cav = new ConstructorArgumentValues();
        cav.addIndexedArgumentValue(0,
                new ConstructorArgumentValues.ValueHolder(CatalogosRepository.class.getName()));
        bd.setConstructorArgumentValues(cav);

        bd.setAttribute("factoryBeanObjectType", CatalogosRepository.class.getName());
        bd.getPropertyValues().add("entidadType", classBean);

        factory.registerBeanDefinition(beanName, bd);
    }

}
