package com.example.splitwise.command;

import com.example.splitwise.controllers.UserController;
import com.example.splitwise.dtos.CreateUserRequestDTO;
import com.example.splitwise.dtos.CreateUserResponseDTO;
import com.example.splitwise.dtos.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommand implements Command{

    private UserController userController;

    @Autowired
    public CreateUserCommand(UserController userController)
    {
        this.userController = userController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("create-user")) return false;

        if(input.split(" ").length != 4) return false;

        return true;
    }

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");
        String userName = parts[1];
        String pwd = parts[2];
        String phoneNumber = parts[3];
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setUserName(userName);
        requestDTO.setPwd(pwd);
        requestDTO.setPhoneNumber(phoneNumber);

        CreateUserResponseDTO responseDTO = userController.createUser(requestDTO);

        if(responseDTO.getResponseStatus().equals(ResponseStatus.Success))
            System.out.println(responseDTO.getMessage() + " , new UserId : " + responseDTO.getUserId() );

        if(responseDTO.getResponseStatus().equals(ResponseStatus.Failure))
            System.out.println(responseDTO.getMessage());
    }
}
