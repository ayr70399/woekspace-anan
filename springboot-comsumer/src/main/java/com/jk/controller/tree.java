package com.jk.controller;

import com.jk.model.Tree;
import com.jk.service.TreeService;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class tree {
    @Autowired
    private TreeService treeservice;
    /**
     * Copyright (C), 2015-2019, jk
     * FileName: TreeController
     * Author:   Lemovo
     * Date:     2019-08-07 11:12
     * Description: 1
     * History:
     * <author>          <time>          <version>          <desc>
     * 安安          修改时间           版本号              描述
     */
    @RequestMapping("showTreeJsp")
    public String showTreeJsp(){
        return "showtree";
    }
    @RequestMapping("queryTreeByUserid")
    @ResponseBody
    public List<Tree> queryTreeByUserid(){
        List<Tree> list=new ArrayList<Tree>();
        list=treeservice.queryTreeByUserid();
        list= TreeNoteUtil.getFatherNode(list);
        System.out.println(list);
        return list;
    }
}

