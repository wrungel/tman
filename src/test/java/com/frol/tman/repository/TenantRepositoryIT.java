/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.frol.tman.repository;

import com.frol.tman.entity.Tenant;
import com.frol.tman.dto.TenantDTO;
import org.hamcrest.Matchers;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 *
 * @author frol
 */
public class TenantRepositoryIT {

    static EntityManagerFactory emf;
    private EntityManager em;

     @BeforeClass
    public static void beforeClass() {
        emf = PersistenceHelper.createDefaultEntityManagerFactory();
    }

    @Before
    public void before() {
        em = emf.createEntityManager();
    }

    @After
    public void after() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();

    }


    @Test
    public void test() {
        em.getTransaction().begin();
        Tenant tenant = new Tenant();
        tenant.setFirstName("Firstname");
        tenant.setSecondName("Secondname");
        tenant.setId("1");
        tenant.setBirthDay(new Date());

        em.persist(tenant);
        TenantRepository sut = new TenantRepository(em);
        TenantDTO dto = sut.findById(tenant.getId());
        assertThat(dto, notNullValue());

        assertThat(dto.getId(), Matchers.is(tenant.getId()));
    }
}
