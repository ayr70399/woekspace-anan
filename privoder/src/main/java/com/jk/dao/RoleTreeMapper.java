package com.jk.dao;

import com.jk.model.RoleTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleTreeMapper {
    int deleteByPrimaryKey(Integer rtid);

    int insert(RoleTree record);

    int insertSelective(RoleTree record);

    RoleTree selectByPrimaryKey(Integer rtid);

    int updateByPrimaryKeySelective(RoleTree record);

    int updateByPrimaryKey(RoleTree record);

    List<RoleTree> queryTreeByRoleid(@Param("rid") Integer rid);

    int deleteByRoleid(@Param("rid") Integer rid);
}