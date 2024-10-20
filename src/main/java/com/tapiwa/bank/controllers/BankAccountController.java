package com.tapiwa.bank.controllers;


import com.tapiwa.bank.models.BankAccount;
import com.tapiwa.bank.serviceInterfaces.BankAccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class BankAccountController {


    @Inject
    private BankAccountService bankAccountService;
    @GET
    public List<BankAccount> getAllAccount(){
        return bankAccountService.getAllBankAccounts();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEntity(BankAccount entity) {
        BankAccount createdEntity = bankAccountService.createBankAccount(entity);
        return Response.status(Response.Status.CREATED).entity(createdEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntity(@PathParam("id") Long id) {
        BankAccount entity = bankAccountService.getBankAccount(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(entity).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEntity(@PathParam("id") Long id, BankAccount updatedEntity) {
        BankAccount entity = bankAccountService.updateBankAccount(id, updatedEntity);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEntity(@PathParam("id") Long id) {
        bankAccountService.deleteBankAccount(id);
        return Response.noContent().build();
    }

}
