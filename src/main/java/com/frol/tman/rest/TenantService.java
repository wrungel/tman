package com.frol.tman.rest;

import com.frol.tman.entity.QTenant;
import com.frol.tman.entity.TenantDTO;
import com.frol.tman.entity.TenantPreviewDTO;
import com.frol.tman.repository.TenantRepository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.PathParam;

@Path("/tenants")
@Stateless
public class TenantService {
    
    @Inject private TenantRepository repository;
    
    @GET
    @Path("/tenant/{id}")
    @Produces("application/json")
    public TenantDTO get(@PathParam("id") String id)
    {
        return repository.findById(id);
    } 

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<TenantPreviewDTO> listAll()
    {
        return repository.findAll();
    }
}
