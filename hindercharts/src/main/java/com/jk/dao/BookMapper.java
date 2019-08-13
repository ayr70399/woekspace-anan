package com.jk.dao;

import com.jk.model.Book;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Map<String, Object>> queryDemo1();

    List<Map<String, Object>> queryDemo2();

    List<Map<String, Object>> queryDemo3();
}