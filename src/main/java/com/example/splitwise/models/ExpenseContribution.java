package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseContribution extends BaseModel{

    @ManyToOne
    private AppUser user;
    @ManyToOne
    private Expense expense;
    private int contributionAmount;


}
