package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private String title;
    private int amount;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseContribution> expenseContributions;
    @OneToMany(mappedBy = "expense")
    private List<ExpenseShare> expenseShares ;


}




/* between an expense and a group
*
*  UserGroup : Expense
*   1grp : mul expenses
* 1/0 grp:  1 expense
*
* even though the relation is 1 : M
*
* it can be nullable as each expense might or might not be
* related to a group so
*
* create a separate sparse table for it
*
* */

/* between an expense and a User
 *
 *      User : Expense
 *   1 User  : m expenses
 *   m users : 1 expense
 *
 * the relation is M : M
 *
 * Now there can be two scenarios as we can create a single List
 * of userExpenses inside the Expense which can store
 * both types of operation Paying and splitting/sharing
 *
 * fot that we have to create a separate mapping table based on
 * 1 user can be involved in mul expenses and 1 expense can have mul users
 *
 * so that userExpense Table will have
 * user
 * Expense
 * Contribution
 * Type of contribution (extra enum we have to create)
 * as it defines the type of contribution
 *
 * other approach can be there can be two separate categories
 * or List of userExpenses inside the Expense table
 *
 * List<PaidByUserExpenses>
 * List<SplitByUserExpenses>
 * both of which have m : m relation with expenses and require a
 * separate mapping table fot both as we created
 *
 * */