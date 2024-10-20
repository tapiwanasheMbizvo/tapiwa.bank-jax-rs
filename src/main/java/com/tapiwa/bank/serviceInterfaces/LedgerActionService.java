package com.tapiwa.bank.serviceInterfaces;


import com.tapiwa.bank.models.LedgerEntry;

import java.util.List;

public interface LedgerActionService {

    LedgerEntry createLedgerEntry(LedgerEntry ledgerEntry);
    List<LedgerEntry> getEntriesForAccountNumber(String accountNumber);
    List<LedgerEntry> getAllLedgerEntries();

}
