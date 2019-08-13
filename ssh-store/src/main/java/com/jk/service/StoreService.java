package com.jk.service;

import java.util.List;

import com.jk.model.StoreType;
import com.jk.model.Strore;

public interface StoreService {

	List<Strore> queryStore(Integer page, Integer rows, Strore store);

	long queryCount();

	List<StoreType> storeservice();

	void addStore(Strore store);

	Strore queryStoreById(Strore store);

	void deleteStore(String delid);


	int queryIns(Strore store);

	List<Strore> queryMyStore();

	void delIns(Integer iid);

}
