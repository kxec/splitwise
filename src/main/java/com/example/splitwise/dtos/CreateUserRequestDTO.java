package com.example.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDTO {

    private String userName;
    private String pwd;
    private String phoneNumber;

}
