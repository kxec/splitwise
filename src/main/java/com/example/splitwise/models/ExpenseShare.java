package com.example.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseShare extends BaseModel{

    @ManyToOne
    private AppUser user;
    @ManyToOne
    private Expense expense;
    private int shareAmount;


}


/*
*
/*
 * One User can be associated with multiple ExpenseShares
 * but one ExpenseShare belongs to only one User.
 *
 * One Expense can contain multiple ExpenseShares
 * but one ExpenseShare belongs to only one Expense.
 */

