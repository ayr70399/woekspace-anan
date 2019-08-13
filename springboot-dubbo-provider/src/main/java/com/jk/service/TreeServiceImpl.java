package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.TreeMapper;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TreeServiceImpl implements  TreeService {
/**
 * Copyright (C), 2015-2019, jk
 * FileName: TreeServiceImpl
 * Author:   Lemovo
 * Date:     2019-08-09 11:58
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
@Autowired
private TreeMapper treemapper;

    @Override
    public List<Tree> queryTreeByUserid() {
       return treemapper.queryTreeByUserid();
    }
}

