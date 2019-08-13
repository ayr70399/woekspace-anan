package com.jk.dao;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//    User queryUserByname(@Param("uname") String uname);

    User queryUserByName(@Param("uname") String uname);
}