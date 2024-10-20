package com.tapiwa.bank.serviceInterfaces;

import com.tapiwa.bank.models.BankAccount;

import java.util.List;


public interface BankAccountService {

    List<BankAccount> getAllBankAccounts();
    BankAccount getBankAccount(Long id);
    BankAccount createBankAccount(BankAccount bankAccount);
    BankAccount  updateBankAccount(Long id, BankAccount bankAccount);
    void deleteBankAccount(Long id);

}
