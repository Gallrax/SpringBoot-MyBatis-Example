package com.sm.service;

import com.sm.entity.User;

import java.util.List;

/**
 * Created by Gallrax on 2017/7/5.
 */
public interface UserSer {

    List<User> findAll();

    User findById(Integer id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}
