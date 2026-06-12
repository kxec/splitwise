package com.example.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDTO {

    private String message;
    private ResponseStatus responseStatus;
    private Long userId;
}
