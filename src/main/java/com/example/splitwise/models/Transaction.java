package com.example.splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

    private int amount;
    private String payer;
    private String payee;

    public Transaction(int amount , String payer , String payee)
    {
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;

    }
    @Override
    public String toString() {
        return payer + " has paid " + payee + " " + amount;
    }
}
