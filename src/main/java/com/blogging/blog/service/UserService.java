package com.blogging.blog.service;

import com.blogging.blog.entity.User;

import java.util.List;

public interface UserService {
    public boolean registerUser(User user);
    public boolean deleteUser(String userId);
    public List<User> getAllUsers();
    public User findByEmail(String email);
    public boolean updateUserInfo(User user);
}
