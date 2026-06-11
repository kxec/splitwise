package com.example.splitwise.services.strategies;

import com.example.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component("roundRobinStrategy")
public class RoundRobinStrategy implements TransactionMinimizationStrategy{
    @Override
    public List<Transaction> settleUp(HashMap<String, Integer> bs) {

        List<String> users = new ArrayList<>(bs.keySet());
        int n = users.size();
        List<Transaction> transactions = new ArrayList<>();

        for(int i = 0 ; i <= n - 2 ; i++)
            {
                String currUser = users.get(i);
                String nxtUser = users.get(i + 1);

                int currUserBal = bs.get(currUser);
                int nxtUserBalance = bs.get(nxtUser);

                if(currUserBal == 0) continue;

                else if(currUserBal > 0)
                    transactions.add(new Transaction(currUserBal , nxtUser , currUser));

                else
                    transactions.add(new Transaction(Math.abs(currUserBal) , currUser , nxtUser));

                nxtUserBalance = nxtUserBalance + currUserBal;

                bs.put(currUser , 0);
                bs.put(nxtUser , nxtUserBalance);

            }

        return transactions;
    }
}
