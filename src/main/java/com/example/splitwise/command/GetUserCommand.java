package com.example.splitwise.command;

import com.example.splitwise.controllers.UserController;
import com.example.splitwise.dtos.GetUserRequestDTO;
import com.example.splitwise.dtos.GetUserResponseDTO;
import com.example.splitwise.dtos.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserCommand implements Command{

    private UserController userController;

    @Autowired
    public GetUserCommand(UserController userController)
    {
        this.userController = userController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("get-user")) return false;

        if(input.split(" ").length != 2) return false;

        return true;
    }

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");
        Long userId = Long.parseLong(parts[1]);
        GetUserRequestDTO requestDTO = new GetUserRequestDTO();
        requestDTO.setUserId(userId);

        GetUserResponseDTO responseDTO = userController.getUserById(requestDTO);

        if(responseDTO.getResponseStatus().equals(ResponseStatus.Success))
            System.out.println("User details are : userName -" + responseDTO.getUserName()
                    + " phoneNumber - " + responseDTO.getPhoneNumber() );

        if(responseDTO.getResponseStatus().equals(ResponseStatus.Failure))
            System.out.println(responseDTO.getMessage());
    }
}
