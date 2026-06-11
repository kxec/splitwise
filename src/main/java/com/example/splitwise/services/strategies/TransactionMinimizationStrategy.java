package com.example.splitwise.services.strategies;

import com.example.splitwise.models.Transaction;

import java.util.HashMap;
import java.util.List;

public interface TransactionMinimizationStrategy {

    List<Transaction> settleUp(HashMap<String , Integer> bs);

}
