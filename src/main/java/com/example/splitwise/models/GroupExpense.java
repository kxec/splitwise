package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupExpense extends BaseModel {

    @ManyToOne
    private UserGroup userGroup;

    @OneToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

}
