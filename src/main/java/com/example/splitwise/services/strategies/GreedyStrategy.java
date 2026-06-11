package com.example.splitwise.services.strategies;

import com.example.splitwise.models.PQUser;
import com.example.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

@Component("greedyStrategy")
public class GreedyStrategy implements TransactionMinimizationStrategy{
    @Override
    public List<Transaction> settleUp(HashMap<String, Integer> bs) {

        PriorityQueue<PQUser> negBalUsers = new PriorityQueue<>();
        PriorityQueue<PQUser> posBalUsers = new PriorityQueue<>();
        List<Transaction> transactions = new ArrayList<>();

       for(String user : bs.keySet())
       {
           int currBal = bs.get(user);
           if(currBal > 0) posBalUsers.add(new PQUser(currBal , user));
           if(currBal < 0) negBalUsers.add(new PQUser(Math.abs(currBal) , user));

       }

       while(!negBalUsers.isEmpty() && !posBalUsers.isEmpty())
       {
           PQUser posUser = posBalUsers.poll();
           PQUser negUser = negBalUsers.poll();

           int minBal = Math.min(posUser.getAmount() , negUser.getAmount());

           posUser.setAmount(posUser.getAmount() - minBal);
           negUser.setAmount(negUser.getAmount() - minBal);

           if(posUser.getAmount() > 0) posBalUsers.add(posUser);
           if(negUser.getAmount() > 0) negBalUsers.add(negUser);

           transactions.add(new Transaction(minBal , negUser.getUser() , posUser.getUser()));

       }

        return transactions;
    }
}
