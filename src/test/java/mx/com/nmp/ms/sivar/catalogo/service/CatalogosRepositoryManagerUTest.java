

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

import mx.com.nmp.ms.sivar.catalogo.SivarCatalogosApplication;
import mx.com.nmp.ms.sivar.catalogo.domain.EntidadCatalogo;
import mx.com.nmp.ms.sivar.catalogo.domain.Marca;
import mx.com.nmp.ms.sivar.catalogo.exception.InternalServerErrorException;
import mx.com.nmp.ms.sivar.catalogo.exception.NotFoundException;
import mx.com.nmp.ms.sivar.catalogo.repository.CatalogosRepository;
import mx.com.nmp.ms.sivar.catalogo.repository.EntidadCatalogoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.PostConstruct;

import java.util.concurrent.ConcurrentHashMap;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


/**
 * Clase de pruebas para la clase {@link CatalogosRepositoryManager}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SivarCatalogosApplication.class)
public class CatalogosRepositoryManagerUTest {

    @MockBean
    private ApplicationContext applicationContext;

    @MockBean
    private EntidadCatalogoRepository entidadCatalogoRepository;

    @MockBean
    private CatalogosRepository catalogosRepository;

    @Autowired
    private CatalogosRepositoryManager catalogosRepositoryManager;

    private DefaultListableBeanFactory dlbf;

    private EntidadCatalogo ec;

    /**
     * Constructor de la prueba
     */
    public CatalogosRepositoryManagerUTest() {
        super();
    }

    /**
     * Inicializa los mock a utilizar
     */
    @PostConstruct
    public void setUp() {
        ReflectionTestUtils.setField(catalogosRepositoryManager, "applicationContext", applicationContext);

        dlbf = new DefaultListableBeanFactory() {
            public BeanDefinition getBeanDefinition(String beanName) {
                return new RootBeanDefinition();
            }
        };

        ec = new EntidadCatalogo();
        ec.setCatalogo("MARCA");
        ec.setEntidad(Marca.class);
    }

    /**
     * Prueba de unidad para {@link CatalogosRepositoryManager#recuperarRepositorio(String)}
     */
    @Test(expected = InternalServerErrorException.class)
    public void recuperarRepositorioErrorInterno() {
        when(entidadCatalogoRepository.findByCatalogo(anyString()))
                .thenThrow(new RuntimeException("Error programado en el repositorio, para pruebas"));

        catalogosRepositoryManager.recuperarRepositorio("MARCA");
    }

    /**
     * Prueba de unidad para {@link CatalogosRepositoryManager#recuperarRepositorio(String)}
     */
    @Test(expected = NotFoundException.class)
    public void recuperarRepositorioNoExiste() {
        when(entidadCatalogoRepository.findByCatalogo(anyString())).thenReturn(null);

        catalogosRepositoryManager.recuperarRepositorio("MARCA");
    }

    /**
     * Prueba de unidad para {@link CatalogosRepositoryManager#recuperarRepositorio(String)}
     */
    @SuppressWarnings("unchecked")
    @Test(expected = InternalServerErrorException.class)
    public void recuperarRepositorioErrorBean() {
        ReflectionTestUtils.setField(
                catalogosRepositoryManager, "repositoryLocalCache", new ConcurrentHashMap<>());

        when(entidadCatalogoRepository.findByCatalogo(anyString())).thenReturn(ec);
        when(applicationContext.getAutowireCapableBeanFactory()).thenReturn(dlbf);
        when(applicationContext.getBean(anyString(), any(Class.class)))
                .thenThrow(new RuntimeException("Error programado en el repositorio, para pruebas"));

        catalogosRepositoryManager.recuperarRepositorio("MARCA");
    }

    /**
     * Prueba de unidad para {@link CatalogosRepositoryManager#recuperarRepositorio(String)}
     */
    @Test
    public void recuperarRepositorio() {
        Object test = recupearRepositorioCatalogoMARCA();
        assertNotNull(test);
    }

    /**
     * Prueba de unidad para {@link CatalogosRepositoryManager#recuperarRepositorio(String)}
     */
    @Test
    @SuppressWarnings("unchecked")
    public void recuperarRepositorioCache() {
        recupearRepositorioCatalogoMARCA();
        Object test = recupearRepositorioCatalogoMARCA();
        assertNotNull(test);
    }

    @SuppressWarnings("unchecked")
    private CatalogosRepository  recupearRepositorioCatalogoMARCA() {
        when(entidadCatalogoRepository.findByCatalogo(anyString())).thenReturn(ec);
        when(applicationContext.getAutowireCapableBeanFactory()).thenReturn(dlbf);
        when(applicationContext.getBean(anyString(), any(Class.class))).thenReturn(catalogosRepository);

        return catalogosRepositoryManager.recuperarRepositorio("MARCA");
    }

}