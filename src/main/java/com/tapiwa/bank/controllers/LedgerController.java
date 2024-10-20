package com.tapiwa.bank.controllers;



import com.tapiwa.bank.models.LedgerEntry;
import com.tapiwa.bank.serviceInterfaces.LedgerActionService;

import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/ledger")
@Produces(MediaType.APPLICATION_JSON)
public class LedgerController {


    @Inject

    private LedgerActionService ledgerActionService;

    @GET
    @Path("/{accountNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LedgerEntry> getTransactionForAccount(@PathParam("accountNumber") String accountNumber)   {

        return  ledgerActionService.getEntriesForAccountNumber(accountNumber);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LedgerEntry> getAllEntries()   {

        return  ledgerActionService.getAllLedgerEntries();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEntity(LedgerEntry ledgerEntry) {
        LedgerEntry createdEntity = ledgerActionService.createLedgerEntry(ledgerEntry);
        return Response.status(Response.Status.CREATED).entity(createdEntity).build();
    }
}
