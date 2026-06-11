package com.example.splitwise.services;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.GroupExpense;
import com.example.splitwise.models.UserGroup;
import com.example.splitwise.repositories.GroupExpenseRepository;
import com.example.splitwise.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GroupService {

    private GroupRepository groupRepository;
    private GroupExpenseRepository groupExpenseRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository , GroupExpenseRepository groupExpenseRepository)
    {
        this.groupRepository = groupRepository;
        this.groupExpenseRepository = groupExpenseRepository;
    }

    public Long getGroupByName(String name)
    {
        Optional<UserGroup> groupWrapper = groupRepository.findByName(name);
        return groupWrapper.get().getId();
    }

    public List<Expense> getAllExpensesByGroup(Long groupId)
    {
        List<GroupExpense> groupExpenses = groupExpenseRepository.findAllByUserGroupId(groupId);
        List<Expense> expenses = new ArrayList<>();

        for(GroupExpense ge : groupExpenses)
            expenses.add(ge.getExpense());

        return expenses;
    }

}
