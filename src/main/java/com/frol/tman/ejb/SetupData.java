package com.frol.tman.ejb;

import com.frol.tman.entity.PhoneNumber;
import com.frol.tman.entity.PhoneType;
import com.frol.tman.entity.Tenant;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.GregorianCalendar;

@Singleton
@Startup
public class SetupData {

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    EntityManager entityManager;

    @PostConstruct
    public void init() {

        Tenant tenant = entityManager.find(Tenant.class, "alex");
        if (tenant != null)
            return;

        tenant = new Tenant();
        tenant.setId("alex");
        tenant.setFirstName("Alexandr");
        tenant.setMiddleName("Mikhailovich");
        tenant.setSecondName("Dobriyakov");

        tenant.setBirthDay(new GregorianCalendar(1970, 2, 25).getTime());
        tenant.getPhoneNumbers().add(new PhoneNumber("7", "812", "5953422", PhoneType.HOME));
        tenant.getPhoneNumbers().add(new PhoneNumber("7", "921", "1238642", PhoneType.MOBILE));

        entityManager.persist(tenant);



        tenant = entityManager.find(Tenant.class, "dariya");
        if (tenant != null)
            return;

        tenant = new Tenant();
        tenant.setId("dariya");
        tenant.setFirstName("Daria");
        tenant.setMiddleName("Sergeevna");
        tenant.setSecondName("Suhorukova");

        tenant.setBirthDay(new GregorianCalendar(1986, 11, 3).getTime());
        tenant.getPhoneNumbers().add(new PhoneNumber("7", "812", "5933477", PhoneType.HOME));
        tenant.getPhoneNumbers().add(new PhoneNumber("7", "921", "2088372", PhoneType.MOBILE));

        entityManager.persist(tenant);

    }
}
