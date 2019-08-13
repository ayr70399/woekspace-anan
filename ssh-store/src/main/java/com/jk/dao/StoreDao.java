package com.jk.dao;

import java.util.List;

import com.jk.model.Instllaction;
import com.jk.model.StoreType;
import com.jk.model.Strore;

public interface StoreDao {

	List<Strore> queryStore(StringBuffer hql, Integer page, Integer page2);

	long queryCount();

	List<StoreType> queryType(StringBuffer hql);

	void addStore(Strore store);

	Strore queryStoreById(Strore store);

	void deleteStore(StringBuffer hql);

	void addIns(Instllaction ins);

	Instllaction queryInsById(Strore store);

	List<Strore> queryMyStore();

	List<Strore> queryMyStore(StringBuffer hql);

}
