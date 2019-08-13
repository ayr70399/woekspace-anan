package com.jk.service;

import com.jk.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {


    User queryUserByName1(String uname);

    Map queryUser(Integer page, Integer rows);

    void addUsers(List<User> list);

    List<User> queryUserList();
}
