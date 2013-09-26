package com.frol.tman.rest;

import com.frol.tman.dto.PaymentPreviewDTO;
import com.frol.tman.dto.TenantDTO;
import com.frol.tman.dto.TenantPreviewDTO;
import com.frol.tman.repository.RentRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/rents")
@Stateless
public class PaymentService {
    
    @Inject private RentRepository repository;
    


    @GET
    @Path("/{rentId}/payments/all   ")
    @Produces("application/json")
    public List<PaymentPreviewDTO> payments(@PathParam("rentId") String rentId)
    {
        return repository.getPayments(Long.parseLong(rentId));
    }
}
