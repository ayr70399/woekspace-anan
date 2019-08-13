package com.jk.controller;

import com.jk.model.Tree;
import com.jk.service.TreeService;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("tree")
public class TreeController {

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


          List<Tree>  list = treeservice.queryTreeByUserid();

            list = TreeNoteUtil.getFatherNode(list);
            //放入缓存中、返回list
            return  list;



    }

}

