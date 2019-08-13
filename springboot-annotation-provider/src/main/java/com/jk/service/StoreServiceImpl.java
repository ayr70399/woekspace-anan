package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.StoreMapper;
import com.jk.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
@Autowired
private StoreMapper storeMapper;

	@Override
	public void addStore(Store store) {
		storeMapper.addStore(store);
	}


	@Override
	public void delStore(String delid) {
		storeMapper.delStore(delid);
 	}

	@Override
	public Map queryStore(Integer page, Integer rows, Store store) {
		long count=storeMapper.queryCount();
		int  stat=(page-1)*rows;
		List<Store> list=storeMapper.queryStore(stat,rows);
		Map map=new HashMap();
		map.put("rows",list);
		map.put("total",count);
		return map;
	}

	@Override
	public void updStore(Store store) {
		storeMapper.updStore(store);
	}

	@Override
	public Store queryStoreById(Integer sid) {
		return storeMapper.queryStoreById(sid);
	}
}
