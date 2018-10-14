

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


package mx.com.nmp.ms.sivar.catalogo;


import mx.com.nmp.ms.sivar.catalogo.factory.JpaRepositoryCatalogosFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Esta aplicación se encargará de atender las peticiones de
 * consulta para los catálogos necesario para cubrir el requerimiento del proyecto SIVA Relojes Fase 1.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@EnableCaching
@SpringBootApplication
@EnableJpaRepositories(value = "mx.com.nmp.ms.sivar.catalogo.repository",
		repositoryFactoryBeanClass = JpaRepositoryCatalogosFactoryBean.class)
public class SivarCatalogosApplication {

    /**
     * Metodo inicial, se encarga de levantar el contexto
     * @param args Argumentos de linea de comandos
     */
	public static void main(String[] args) {
		SpringApplication.run(SivarCatalogosApplication.class, args);
	}
}
