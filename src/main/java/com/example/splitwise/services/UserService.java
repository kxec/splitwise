package com.example.splitwise.services;

import com.example.splitwise.models.AppUser;
import com.example.splitwise.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private AppUserRepository appUserRepository;

    @Autowired
    public UserService(AppUserRepository appUserRepository)
    {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getUserById (Long userId)
    {
        return appUserRepository.findById(userId).get();
    }

    public Long createUser (String userName , String pwd , String phoneNumber)
    {
        AppUser user = new AppUser();
        user.setUserName(userName);
        user.setPassWord(pwd);
        user.setPhoneNumber(phoneNumber);

        AppUser savedUser = appUserRepository.save(user);
        return savedUser.getId();
    }
}
