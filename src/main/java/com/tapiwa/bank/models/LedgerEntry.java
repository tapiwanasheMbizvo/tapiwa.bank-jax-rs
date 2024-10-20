package com.tapiwa.bank.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ledger_entries")
public class LedgerEntry {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private String  accountNumber;

    private BigDecimal amount;

    private Boolean debit;


    public LedgerEntry() {
    }

    public LedgerEntry(Long id, String accountNumber, BigDecimal amount, Boolean debit) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.debit = debit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getDebit() {
        return debit;
    }

    public void setDebit(Boolean debit) {
        this.debit = debit;
    }
}
