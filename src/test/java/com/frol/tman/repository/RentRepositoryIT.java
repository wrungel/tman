/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.frol.tman.repository;

import com.frol.tman.dto.PaymentPreviewDTO;
import com.frol.tman.entity.*;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RentRepositoryIT {

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

        Apartment apartment = new Apartment();
        apartment.setAddress("Maxstr");
        apartment.setId("maxstr");
        apartment.setPhoneNumber(new PhoneNumber("1", "22", "19283719", PhoneType.HOME));
        em.persist(apartment);

        Rent rent = new Rent();
        rent.setApartment(apartment);
        rent.setCurrency("RU");
        rent.setMainTenant(tenant);
        rent.setContractBegin(new GregorianCalendar(2013, 8, 20).getTime());
        rent.setContractEnd(new GregorianCalendar(2014, 7, 19).getTime());

        rent.setMonthRate(14000);
        rent.setSecurityDeposit(14000);
        em.persist(rent);

        Payment payment = new Payment();
        payment.setRent(rent);
        payment.setInCash(true);
        payment.setInfo("security deposit");
        payment.setAmount(14000);
        payment.setDate(new GregorianCalendar(2013, 8, 19).getTime());
        rent.getPayments().add(payment);

        Payment payment2 = new Payment();
        payment2.setRent(rent);
        payment2.setInCash(true);
        payment2.setInfo("regular");
        payment2.setAmount(12000);
        payment2.setDate(new GregorianCalendar(2013, 9, 21).getTime());
        rent.getPayments().add(payment2);


        RentRepository sut = new RentRepository(em);
        List<PaymentPreviewDTO> payments = sut.getPayments(rent.getId());
        assertThat(payments, notNullValue());

        assertThat(payments.size(), Matchers.is(2));
        assertThat(payments.get(0).getAmount(), Matchers.is(14000));
        assertThat(payments.get(1).getAmount(), Matchers.is(12000));
    }
}
