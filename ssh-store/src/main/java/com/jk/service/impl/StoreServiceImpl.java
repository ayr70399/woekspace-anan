package com.jk.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.StoreDao;
import com.jk.model.Instllaction;
import com.jk.model.StoreType;
import com.jk.model.Strore;
import com.jk.service.StoreService;
@Service
public class StoreServiceImpl implements StoreService {
@Autowired
private StoreDao storedao;

public List<Strore> queryStore(Integer page, Integer rows, Strore store) {
	StringBuffer hql= new StringBuffer("select new map(s.sid as sid,s.sname as sname,s.simg as simg,s.steam as steam,s.sversion as sversion ,s.sscore as sscore,t.tname as tname,s.slanguage as slanguage,s.sinfo as sinfo )from Strore s,StoreType t where s.stype=t.tid");
	//StringBuffer hql= new StringBuffer(" from Strore s,StoreType t where s.stype=t.tid");
	return storedao.queryStore(hql,page,rows);
}

public long queryCount() {
	return storedao.queryCount();
}

public List<StoreType> storeservice() {
	StringBuffer hql=new StringBuffer(" from  StoreType where 1=1 ");
	return storedao.queryType(hql);
}

public void addStore(Strore store) {
	store.setStype(1);
	storedao.addStore(store);
}

public Strore queryStoreById(Strore store) {
	// TODO Auto-generated method stub
	return storedao.queryStoreById(store);
}

public void deleteStore(String delid) {
	StringBuffer hql= new StringBuffer("delete from Strore where sid in("+delid+")");
	storedao.deleteStore(hql);
}

public int queryIns(Strore store) {
	Instllaction store1=storedao.queryInsById(store);
	if(store1==null){
		 Instllaction ins =new Instllaction();	
		 ins.setIdate(new Date());
		 ins.setSid(store.getSid());
		 storedao.addIns(ins);
		 return 1;
	}
	return 2;
}

public List<Strore> queryMyStore() {
	StringBuffer hql= new StringBuffer("from Strore s,StoreType t,Instllaction i where s.stype=t.tid  and i.sid=s.sid order by i.idate desc" );
	return storedao.queryMyStore(hql);
}

public void delIns(Integer iid) {
StringBuffer hql= new StringBuffer("delete from Instllaction where iid="+iid);
storedao.deleteStore(hql);
}
}
