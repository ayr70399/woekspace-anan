package com.jk.dao;

import com.jk.model.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Store> queryStore(@Param("stat") Integer stat, @Param("rows") Integer rows);

    long queryCount();

    void addStore(Store store);

    void delStore(@Param("delid") String delid);

    Store queryStoreById(@Param("sid") Integer sid);

    void updStore(Store store);
}