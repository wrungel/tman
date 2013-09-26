package com.frol.tman.repository;

import com.frol.tman.entity.Tenant;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class PersistenceHelper {
    public static EntityManagerFactory createDefaultEntityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setJpaPropertyMap(createDefaultJpaProperties());
        //factoryBean.setPersistenceUnitName("default");
        factoryBean.setPackagesToScan(
                Tenant.class.getPackage().getName());
        factoryBean.setDataSource(createInMemoryDataSource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    protected static Map<String, String> createDefaultJpaProperties() {
        Map<String, String> jpaProperties = new HashMap<>();
        jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        jpaProperties.put(AvailableSettings.DIALECT, H2Dialect.class.getName());
        //jpaProperties.put("hibernate.search.autoregister_listeners", "false");
        //jpaProperties.put("javax.persistence.validation.mode", "none");
        return jpaProperties;
    }


    private static DataSource createInMemoryDataSource() {
        return new SingleConnectionDataSource("jdbc:h2:mem:;", true);
    }

}
