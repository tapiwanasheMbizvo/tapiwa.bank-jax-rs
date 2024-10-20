package com.tapiwa.bank.servicesImpl;

import com.tapiwa.bank.models.BankAccount;
import com.tapiwa.bank.serviceInterfaces.BankAccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Named
@ApplicationScoped
public class BankAccountServiceImpl implements BankAccountService {

    private static final String BANK_PU = "account-pu";
    @PersistenceContext(unitName = BANK_PU)
    private EntityManager entityManager;


    @Override
    public List<BankAccount> getAllBankAccounts() {
        return entityManager
                .createQuery("SELECT account from BankAccount account",
                        BankAccount.class)
                .getResultList();
    }

    @Override
    public BankAccount getBankAccount(Long id) {
        BankAccount bankAccount = entityManager.find(BankAccount.class, id);

        return bankAccount;


    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        entityManager.getTransaction().begin();
        entityManager.persist(bankAccount);
        entityManager.getTransaction().commit();

        return bankAccount;
    }

    @Override
    public BankAccount updateBankAccount(Long id, BankAccount bankAccount) {
       entityManager.getTransaction().begin();
       BankAccount account = entityManager.find(BankAccount.class, id);
       if(account !=null){
           account.setAccountNumber(bankAccount.getAccountNumber());
           account.setBalance(bankAccount.getBalance());
           entityManager.getTransaction().commit();
       }else{

           entityManager.getTransaction().rollback();
       }


       return  account;
    }

    @Override
    public void deleteBankAccount(Long id) {

        entityManager.getTransaction().begin();
        BankAccount bankAccount = entityManager.find(BankAccount.class, id);
        if (bankAccount !=null){

            entityManager.remove(bankAccount);
        }
        entityManager.getTransaction().commit();


    }
}
