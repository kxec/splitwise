package com.example.splitwise.services;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseContribution;
import com.example.splitwise.models.ExpenseShare;
import com.example.splitwise.models.Transaction;
import com.example.splitwise.services.strategies.TransactionMinimizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SettleUpService {

    private GroupService groupService;
    private TransactionMinimizationStrategy strategy;

    @Autowired
    public SettleUpService(GroupService groupService ,@Qualifier("greedyStrategy")  TransactionMinimizationStrategy strategy)
    {
        this.groupService = groupService;
        this.strategy = strategy;
    }

    private HashMap<String , Integer> createBalanceSheet(String groupName)
    {
        Long groupId = groupService.getGroupByName(groupName);
        List<Expense> expenses = groupService.getAllExpensesByGroup(groupId);
        HashMap<String , Integer> balanceSheet = new HashMap<>();

        List<ExpenseContribution> payers = new ArrayList<>();
        List<ExpenseShare> payee = new ArrayList<>();

        for(Expense exp : expenses)
        {
            payers.addAll(exp.getExpenseContributions());
            payee.addAll(exp.getExpenseShares());
        }

        for(ExpenseContribution expCon : payers)
        {
            String userName = expCon.getUser().getUserName();
            balanceSheet.put(userName, balanceSheet.getOrDefault(userName , 0) + expCon.getContributionAmount());
        }

        for(ExpenseShare expShr : payee)
        {
            String userName = expShr.getUser().getUserName();
            balanceSheet.put(userName, balanceSheet.getOrDefault(userName , 0) - expShr.getShareAmount());
        }

        return balanceSheet;
    }

    public List<Transaction> settleUpGroup(String groupName)
    {
        HashMap<String , Integer> bs = createBalanceSheet(groupName);
        return strategy.settleUp(bs);
    }

}
