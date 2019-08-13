package com.jk.service;

import com.jk.dao.RoleTreeMapper;
import com.jk.dao.TreeMapper;
import com.jk.model.RoleTree;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="treeService")
@Transactional
public class TreeServiceImpl implements  TreeService{
    @Autowired
    private TreeMapper treemapper;
    @Autowired
    private RoleTreeMapper roletreemapper;
    @Override
    public List<Tree> queryTreeByUserid(Integer uid) {
        return treemapper.queryTreeByUserid(uid);
    }

    @Override
    public Map queryTree(Integer page, Integer rows) {
        int stat=(page-1)*rows;
        long count=treemapper.queryCount();
        List<Tree> list =treemapper.queryTree(stat,rows);
        Map map =new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }

    @Override
    public List<Tree> queryTreeByRoleid(Integer rid) {
        List<RoleTree> list1=roletreemapper.queryTreeByRoleid(rid);
        List<Tree>  list2=treemapper.queryTree1();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if(list1.get(i).getId()==list2.get(j).getId()){
                    list2.get(j).setChecked("true");
                }
            }
        }
        return list2;
    }

    @Override
    public int updateRoleTree(Integer[] treecheckid, Integer rid) {
        int  flag= roletreemapper.deleteByRoleid(rid);
        System.out.println("flag=++++++++++"+flag);
        if(flag>=0){
            for (int i = 0; i < treecheckid.length; i++) {
                RoleTree roletree=new  RoleTree();
                roletree.setId(treecheckid[i]);
                roletree.setRid(rid);
                flag=roletreemapper.insert(roletree);
            }
        }
        return flag;
    }
/**
 * Copyright (C), 2015-2019, jk
 * FileName: TreeServiceImpl
 * Author:   Lemovo
 * Date:     2019-08-07 11:11
 * Description: q
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
}

