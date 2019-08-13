package com.jk.service;


import com.jk.dao.RoleMapper;
import com.jk.dao.UserRoleMapper;
import com.jk.model.Role;
import com.jk.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="roleService")
public class RoleServiceImpl implements  RoleService {
    @Autowired
    private RoleMapper rolemapper;
    @Autowired
    private UserRoleMapper userrolemapper;
/**
 * Copyright (C), 2015-2019, jk
 * FileName: RoleServiceImpl
 * Author:   Lemovo
 * Date:     2019-08-09 11:59
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
public List<Role> queryRoleByUserid(Integer uid) {
    List<Role>  list2=rolemapper.queryRoleAll();
    List<UserRole> list1=userrolemapper.queryRoleByUserid(uid);
    for (int i = 0; i < list1.size(); i++) {
        for (int j = 0; j < list2.size(); j++) {
            if(list1.get(i).getRid()==(list2.get(j).getRid())){
                list2.get(j).setChecked(true+"");
            }
        }
    }
    return list2;
}

    /* (non-Javadoc)
     * @see com.jk.role.service.RoleService#updateUserRole(java.lang.Integer[], java.lang.Integer)
     */
    public int updateUserRole(Integer[] rolecheckid, Integer uid) {
        int flag=userrolemapper.deleteUserRole(uid);
        if(flag>=0){
            for (int i = 0; i < rolecheckid.length; i++) {
                UserRole  userrole=new UserRole();
                userrole.setUid(uid);
                userrole.setRid(rolecheckid[i]);
                userrolemapper.insert(userrole);

            }
        }
        return flag;

    }

    @Override
    public Map queryRole(Integer page, Integer rows) {
        int stat=(page-1)*rows;
        long count=rolemapper.queryCount();
        List<Role> list =rolemapper.queryRole(stat,rows);
        Map map =new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }
}

