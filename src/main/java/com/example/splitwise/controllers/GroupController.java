package com.example.splitwise.controllers;

import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.dtos.SettleUpRequestDTO;
import com.example.splitwise.dtos.SettleUpResponseDTO;
import com.example.splitwise.models.Transaction;
import com.example.splitwise.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class GroupController{

    private SettleUpService settleUpService;

    @Autowired
    public GroupController(SettleUpService settleUpService)
    {
        this.settleUpService = settleUpService;
    }

    public SettleUpResponseDTO settleUp(SettleUpRequestDTO settleUpRequestDTO)
    {
        SettleUpResponseDTO responseDTO = new SettleUpResponseDTO();

        try{
            List<Transaction> transactions = settleUpService.settleUpGroup(settleUpRequestDTO.getGroupName());
            responseDTO.setTransactions(transactions);
            responseDTO.setStatus(ResponseStatus.Success);
            responseDTO.setMessage("Settling up Succeeded");

        }catch(Exception e)
        {
           responseDTO.setMessage("Settling up Failure");
           responseDTO.setStatus(ResponseStatus.Failure);
        }

        return responseDTO;
    }



}
