package mx.com.nmp.ms.sivar.catalogo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.PooledServiceConnectorConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Configuración de aspectos relacionados con base de datos en ambiente cloud
 */
@Configuration
@Profile("cloud")
public class CloudDatabaseConfiguration extends AbstractCloudConfig {

    private final Logger LOGGER = LoggerFactory.getLogger(CloudDatabaseConfiguration.class);

    @Bean
    public DataSource dataSource() {
        LOGGER.info("Configurando datasource JDBC desde proveedor cloud...");
        PooledServiceConnectorConfig.PoolConfig poolConfig = new PooledServiceConnectorConfig.PoolConfig(10, 50, 3000);
        DataSourceConfig dbConfig = new DataSourceConfig(poolConfig, null);
        return connectionFactory().dataSource(dbConfig);
    }

}