package com.sm.dao;

import com.sm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Gallrax on 2017/7/5.
 */
public interface UserDao {

    List<User> findAll();

    User findById(@Param("id") Integer id);

    int addUser(@Param("user") User user);

    void updateUser(@Param("user") User user);

    void deleteUser(@Param("id") Integer id);
}
