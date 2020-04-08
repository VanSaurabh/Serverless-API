package com.serverless.commons.model;

import javax.persistence.*;

@Entity
@Table(name = "Transfer_Detail")
public class TransferDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String withdrawAccountNumber;
    private String depositAccountNumber;
    private String transactionAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWithdrawAccountNumber() {
        return withdrawAccountNumber;
    }

    public void setWithdrawAccountNumber(String withdrawAccountNumber) {
        this.withdrawAccountNumber = withdrawAccountNumber;
    }

    public String getDepositAccountNumber() {
        return depositAccountNumber;
    }

    public void setDepositAccountNumber(String depositAccountNumber) {
        this.depositAccountNumber = depositAccountNumber;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
