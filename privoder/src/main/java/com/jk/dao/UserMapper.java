package com.jk.dao;

import com.jk.model.Tree;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//    User queryUserByname(@Param("uname") String uname);

    User queryUserByName1(@Param("uname") String uname);

    long queryCount();

    List<Tree> queryUser(@Param("stat") int stat, @Param("rows") Integer rows);

    void addUsers(List<User> list);

    List<User> queryUserList();
}