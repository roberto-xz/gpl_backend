
package com.geoplace.gpl_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geoplace.gpl_api.dtos.property.createUserRequestDto;
import com.geoplace.gpl_api.services.UserService;


@RestController
@RequestMapping("/geoplace/api/{token}/user")
public class UserController {
    
    @Autowired
    UserService user;

    @PostMapping("/create")
    public Object create_(@PathVariable String token, @RequestBody createUserRequestDto req) {
        return user.createUser(req);
    }
}
