package com.example.splitwise.command;

import com.example.splitwise.controllers.GroupController;
import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.dtos.SettleUpRequestDTO;
import com.example.splitwise.dtos.SettleUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SettleGroupCommand implements Command{

    private GroupController groupController;

    @Autowired
    public SettleGroupCommand(GroupController groupController)
    {
        this.groupController = groupController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("settle-group")) return false;

        if(input.split(" ").length != 2) return false;

        return true;
    }

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");
        String groupName = parts[1];
        SettleUpRequestDTO requestDTO = new SettleUpRequestDTO();
        requestDTO.setGroupName(groupName);

        SettleUpResponseDTO responseDTO = groupController.settleUpGroup(requestDTO);

        if(responseDTO.getStatus().equals(ResponseStatus.Success))
            System.out.println(responseDTO.getMessage() + " Follow the given Transactions : " + responseDTO.getTransactions());

        if(responseDTO.getStatus().equals(ResponseStatus.Failure))
            System.out.println(responseDTO.getMessage());
    }
}
