package com.serverless.commons;

public class TransferRequest {

    private String id;
    private String withdrawAccountNumber;
    private String depositAccountNumber;
    private String transactionAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
