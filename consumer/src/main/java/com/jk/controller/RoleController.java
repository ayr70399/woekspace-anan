package com.jk.controller;

import com.jk.model.Role;
import com.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleservice;
/**
 * Copyright (C), 2015-2019, jk
 * FileName: RoleController
 * Author:   Lemovo
 * Date:     2019-08-09 19:51
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
@RequestMapping("queryRoleByUserid")
@ResponseBody
public List<Role> queryRoleByUserid(Integer  uid, Model model){
    List<Role> list=roleservice.queryRoleByUserid(uid);
    return list;
}
    //根据用户ID 和 修改后的id  进行 用户角色的修改
    @RequestMapping("updateUserRole")
    @ResponseBody
    public  String  updateUserRole(Integer[] Rolecheckid,Integer  uid){
        int  flag=roleservice.updateUserRole(Rolecheckid,uid);
        return  flag+"";
    }
    @RequestMapping("queryRoleJsp")
    public String  queryRoleJsp(){
       return "showrolejsp";
    }
    @RequestMapping("queryRole")
    @ResponseBody
    public Map queryRole(Integer page,Integer rows){
       return roleservice.queryRole(page,rows);
    }
}

