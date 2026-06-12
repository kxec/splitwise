package com.example.splitwise.controllers;

import com.example.splitwise.dtos.*;
import com.example.splitwise.models.AppUser;
import com.example.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    public GetUserResponseDTO getUserById(GetUserRequestDTO getUserRequestDTO)
    {
        GetUserResponseDTO responseDTO = new GetUserResponseDTO();

        try{

            AppUser user = userService.getUserById(getUserRequestDTO.getUserId());
            responseDTO.setUserName(user.getUserName());
            responseDTO.setPhoneNumber(user.getPhoneNumber());
            responseDTO.setResponseStatus(ResponseStatus.Success);
            responseDTO.setMessage("Fetching User Succeeded");


        }catch(Exception e)
        {
            responseDTO.setResponseStatus(ResponseStatus.Failure);
            responseDTO.setMessage("Fetching User Failed");

        }

        return responseDTO;

    }

    public CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO)
    {
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();

        try{
            Long id = userService.createUser(createUserRequestDTO.getUserName() , createUserRequestDTO.getPwd() , createUserRequestDTO.getPhoneNumber());
            responseDTO.setUserId(id);
            responseDTO.setResponseStatus(ResponseStatus.Success);
            responseDTO.setMessage("User Creation Succeeded");
        }catch(Exception e)
        {
            responseDTO.setResponseStatus(ResponseStatus.Failure);
            responseDTO.setMessage("User Creation Failed");
        }

        return responseDTO;

    }


}
