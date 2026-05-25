package com.example.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AppUser extends BaseModel{

    private String userName;
    private String passWord;
    private String phoneNumber;

}
