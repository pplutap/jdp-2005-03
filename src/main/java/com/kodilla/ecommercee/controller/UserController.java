package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecommercee/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(UserDto userDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(Long userId) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "generateKey")
    public Long generateKey(UserDto userDto) {
        return 1234567L;
    }
}
