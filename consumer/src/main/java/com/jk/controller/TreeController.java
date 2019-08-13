package com.jk.controller;

import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.TreeService;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("tree")
public class TreeController {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
/**
 * Copyright (C), 2015-2019, jk
 * FileName: TreeController
 * Author:   Lemovo
 * Date:     2019-08-09 15:50
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
@Autowired
private TreeService treeservice;
@RequestMapping("showTreeJsp")
public String showTreeJsp(){
    return "showtree";
}
    @RequestMapping("queryTreeByUserid")
    @ResponseBody
    public List<Tree> queryTreeByUserid(HttpSession session){

        User loginUser = (User) session.getAttribute("loginUser");

        List<Tree> list = new ArrayList<Tree>();
        //1、定义缓存key
        String key = "tree"+loginUser.getUid();
        //2、先判断缓存中是否存在
        if(redisTemplate.hasKey(key)){
            System.out.println("=====走缓存=======");
            //3、a 存在 ：从缓存中获取，返回list
            list = (List<Tree>) redisTemplate.opsForValue().get(key);
        }else{
            System.out.println("=====走数据库=======");
            //3、 b 不存在：
            //先从数据库查询、
            list = treeservice.queryTreeByUserid(loginUser.getUid());

            list = TreeNoteUtil.getFatherNode(list);
            //放入缓存中、返回list
            redisTemplate.opsForValue().set(key, list);
            //设置过期时间
            redisTemplate.expire(key, 30, TimeUnit.MINUTES);
        }

        return list;
    }
    @RequestMapping("queryTreeJsp")
    public String  queryTreeJsp(){
    return "showtreejsp";
    }
    @RequestMapping("queryTree")
    @ResponseBody
    public Map queryTree(Integer page ,Integer rows){
    return  treeservice.queryTree(page,rows);
    }
    @RequestMapping("showCheckedTree")
    @ResponseBody
    public List<Tree>  showCheckedTree(Integer  rid){

        List<Tree> list=treeservice.queryTreeByRoleid(rid);
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }
    @RequestMapping("updateRoleTree")
    @ResponseBody
    public  String  updateRoleTree(Integer[] treecheckid,Integer rid){
        int  flag=treeservice.updateRoleTree(treecheckid,rid);
        return  flag+"";
    }
}

