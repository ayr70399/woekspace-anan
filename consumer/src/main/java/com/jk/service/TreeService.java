package com.jk.service;

import com.jk.model.Tree;

import java.util.List;
import java.util.Map;

public interface TreeService {
    List<Tree> queryTreeByUserid(Integer uid);

    Map queryTree(Integer page, Integer rows);

    List<Tree> queryTreeByRoleid(Integer rid);

    int updateRoleTree(Integer[] treecheckid, Integer rid);
}
