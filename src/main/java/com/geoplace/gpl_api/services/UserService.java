package com.geoplace.gpl_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geoplace.gpl_api.dtos.property.createUserRequestDto;
import com.geoplace.gpl_api.models.UserModel;
import com.geoplace.gpl_api.repositories.UserRepository;

@Service
public class UserService {
    UserRepository user;

    @Autowired
    public UserService(UserRepository user) { this.user = user;}
    
    public Object createUser(createUserRequestDto user) {
        UserModel newUser = new UserModel();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        return this.user.save(newUser);
    }
}
