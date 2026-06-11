package com.example.splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PQUser implements Comparable<PQUser>{

    private int amount;
    private String user;

    public PQUser(int amount , String user)
    {
        this.user = user;
        this.amount = amount;
    }

    public int compareTo(PQUser u1)
    {
        return Integer.compare(u1.amount , this.amount);
    }
}
