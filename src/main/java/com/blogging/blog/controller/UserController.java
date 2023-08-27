package com.blogging.blog.controller;

import com.blogging.blog.entity.User;
import com.blogging.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody User user){
        if(userService.registerUser(user))
            return user.toString() + " registered successfully.";
        throw new RuntimeException("Could not save user");
    }

    @GetMapping("/user/email")
    public String getUserByEmail(@Valid @RequestBody String email){
        return userService.findByEmail(email).toString() + " is the user found.";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public String deleteUser(@Valid @RequestBody String userId){
        if(userService.deleteUser(userId))
            return "User " + userId + " deleted successfully.";
        throw new RuntimeException("Could not delete user");
    }

    @PutMapping("/update")
    public String updateUserDetails(@Valid @RequestBody User user){
        if(userService.updateUserInfo(user))
            return user.toString() + " is the updated value";
        throw new RuntimeException("Could not update user details");
    }
}
