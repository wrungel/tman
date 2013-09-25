package com.frol.tman.rest;

import com.frol.tman.entity.QTenant;
import com.frol.tman.entity.TenantDTO;
import com.frol.tman.entity.TenantPreviewDTO;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import javax.ws.rs.PathParam;

@Path("/tenant")
@Stateless
public class TenantService {

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    EntityManager em;

    @GET
    @Path("tenant/{id}")
    @Produces("application/json")
    public TenantDTO get(@PathParam("id") String id)
    {
        return new JPAQuery(em).from(QTenant.tenant).
                where(QTenant.tenant.id.eq(id)).
                singleResult(
                Projections.bean(
                        TenantDTO.class,
                        QTenant.tenant.firstName,
                        QTenant.tenant.middleName,
                        QTenant.tenant.secondName,
                        QTenant.tenant.birthDay,
                        QTenant.tenant.phoneNumbers));
    } 

    @GET
    @Path("all")
    @Produces("application/json")
    public List<TenantPreviewDTO> listAll()
    {
        return new JPAQuery(em).from(QTenant.tenant).list(
                Projections.bean(
                        TenantPreviewDTO.class,
                        QTenant.tenant.firstName,
                        QTenant.tenant.middleName,
                        QTenant.tenant.secondName));
    }
}
