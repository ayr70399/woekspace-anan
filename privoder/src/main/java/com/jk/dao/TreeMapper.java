package com.jk.dao;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tree record);

    int insertSelective(Tree record);

    Tree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);

    List<Tree> queryTreeByUserid(@Param("uid") Integer uid);

    long queryCount();

    List<Tree> queryTree(@Param("stat") int stat, @Param("rows") Integer rows);

    List<Tree> queryTree1();
}