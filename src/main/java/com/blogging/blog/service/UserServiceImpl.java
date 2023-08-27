package com.blogging.blog.service;

import com.blogging.blog.entity.User;
import com.blogging.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean registerUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(String userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return (User) userRepository.findByEmail(email);
    }

    @Override
    public boolean updateUserInfo(User user) {
        User updatedUser = userRepository.findById(user.getUserId()).get();
        if(updatedUser==null)
            return false;
        if(user.getUserId()!=null)
            updatedUser.setUserId(user.getUserId());
        if(user.getEmail()!=null)
            updatedUser.setEmail(user.getEmail());
        if(user.getFirstName()!=null)
            updatedUser.setFirstName(user.getFirstName());
        if(user.getLastName()!=null)
            updatedUser.setLastName(user.getLastName());
        if(user.getPassword()!=null)
            updatedUser.setPassword(user.getPassword());
        userRepository.save(updatedUser);
        return true;
    }
}
