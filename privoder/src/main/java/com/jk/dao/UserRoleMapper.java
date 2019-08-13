package com.jk.dao;

import com.jk.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

  

    int deleteUserRole(@Param("uid") Integer uid);

    List<UserRole> queryRoleByUserid(@Param("uid") Integer uid);
}