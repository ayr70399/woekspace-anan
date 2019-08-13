package com.jk.service;

import com.jk.dao.TreeMapper;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value="treeService")
@Transactional
public class TreeServiceImpl implements  TreeService{
    @Autowired
    private TreeMapper treemapper;

    @Override
    public List<Tree> queryTreeByUserid() {
        return treemapper.queryTreeByUserid();
    }


}

