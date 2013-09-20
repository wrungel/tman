package com.frol.tman.rest;

import com.frol.tman.model.QTenant;
import com.frol.tman.model.TenantDTO;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/tenant")
@Stateless
public class TenantService {

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    EntityManager em;



    @GET
    @Path("all")
    @Produces("application/json")
    public List<TenantDTO> listAll()
    {


        return new JPAQuery(em).from(QTenant.tenant).list(
                Projections.bean(
                        TenantDTO.class,
                        QTenant.tenant.firstName,
                        QTenant.tenant.middleName,
                        QTenant.tenant.secondName));
    }
}
