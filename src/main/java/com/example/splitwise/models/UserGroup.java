package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class UserGroup extends BaseModel {

    private String name;
    @OneToMany(mappedBy = "userGroup")
    private List<GroupParticipants> groupParticipants;

    @OneToMany(mappedBy = "userGroup")
    private List<GroupExpense> groupExpenses;

}
