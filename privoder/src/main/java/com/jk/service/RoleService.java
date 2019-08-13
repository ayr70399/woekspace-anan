package com.jk.service;

import com.jk.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> queryRoleByUserid(Integer uid);

    int updateUserRole(Integer[] rolecheckid, Integer uid);

    Map queryRole(Integer page, Integer rows);
}
