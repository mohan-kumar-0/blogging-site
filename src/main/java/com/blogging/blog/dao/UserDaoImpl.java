package com.blogging.blog.dao;

import com.blogging.blog.entity.User;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDaoImpl implements UserDao{

    private HibernateTemplate hTemplate;

    public void sethTemplate(HibernateTemplate hTemplate) {
        this.hTemplate = hTemplate;
    }
    @Override
    @Transactional
    public boolean registerUser(User user) {
        hTemplate.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(String userId) {
        User user = hTemplate.get(User.class, userId);
        hTemplate.delete(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return hTemplate.loadAll(User.class);
    }

    @Override
    public User findByEmail(String email) {
        User user = hTemplate.get(User.class, email);
        return user;
    }

    @Override
    public boolean updateUserInfo(User user) {
        hTemplate.update(user);
        return true;
    }
}
