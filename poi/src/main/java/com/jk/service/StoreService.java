package com.jk.service;

import com.jk.model.Store;

import java.util.List;
import java.util.Map;

public interface StoreService {





	void addStore(Store store);
	void delStore(String delid);
	Map queryStore(Integer page, Integer rows, Store store);
	void updStore(Store store);
	Store queryStoreById(Integer sid);

	List<Store> queryStore();

    void addStores(List<Store> list);
}
