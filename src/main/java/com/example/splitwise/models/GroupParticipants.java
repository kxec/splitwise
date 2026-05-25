package com.example.splitwise.models;

import com.example.splitwise.models.Enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupParticipants extends BaseModel{

    // 1 user can be participant in many groups
    @ManyToOne
    private AppUser user;

    // 1 userGroup can have many userGroup participants
    @ManyToOne
    private UserGroup userGroup;

    @Enumerated
    private Role role;

}
