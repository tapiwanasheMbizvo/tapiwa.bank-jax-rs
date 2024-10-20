package com.tapiwa.bank.servicesImpl;

import com.tapiwa.bank.models.LedgerEntry;
import com.tapiwa.bank.serviceInterfaces.LedgerActionService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Named
@ApplicationScoped
public class LedgerActionServiceImpl implements LedgerActionService {

    private static final String LEDGER_PU = "ledger-pu";
    @PersistenceContext(unitName = LEDGER_PU)
    private EntityManager entityManager;

    @Override
    public LedgerEntry createLedgerEntry(LedgerEntry ledgerEntry) {
        entityManager.getTransaction().begin();
        entityManager.persist(ledgerEntry);
        entityManager.getTransaction().commit();
        return ledgerEntry;
    }

    @Override
    public List<LedgerEntry> getEntriesForAccountNumber(String accountNumber) {

        TypedQuery<LedgerEntry>  query = entityManager.createQuery("SELECT le from LedgerEntry le where le.accountNumber = :accountNumber", LedgerEntry.class);
        query.setParameter("accountNumber", accountNumber);
        return query.getResultList();
    }

    @Override
    public List<LedgerEntry> getAllLedgerEntries() {
        TypedQuery<LedgerEntry>  query = entityManager.createQuery("SELECT le from LedgerEntry le", LedgerEntry.class);

        return query.getResultList();
    }
}
