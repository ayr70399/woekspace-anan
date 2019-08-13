package com.jk.service;

import com.jk.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class BookServiceImpl implements  BookService {
    @Autowired
    private BookMapper bookmapper;
    @Override
    public List<Map<String, Object>> queryDemo1() {
        return bookmapper.queryDemo1();
    }

    @Override
    public List<Map<String, Object>> queryDemo2() {
        return bookmapper.queryDemo2();
    }

    @Override
    public List<Map<String, Object>> queryDemo3() {
        return bookmapper.queryDemo3();
    }
/**
 * Copyright (C), 2015-2019, jk
 * FileName: BookServiceImpl
 * Author:   Lemovo
 * Date:     2019-08-12 19:15
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
}

