package com.example.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponseDTO {
    private String userName;
    private String phoneNumber;
    private ResponseStatus responseStatus;
    private String message;
}
