package com.jk.dao.impl;

import com.jk.dao.StoreDao;
import com.jk.model.Instllaction;
import com.jk.model.StoreType;
import com.jk.model.Strore;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StoreDaoImpl implements StoreDao {
@Autowired
private SessionFactory sessionfactory;

public long queryCount() {
	// TODO Auto-generated method stub
	return (Long) sessionfactory.getCurrentSession().createQuery("select count(*) from Strore ").uniqueResult();
}

public List<Strore> queryStore(StringBuffer hql, Integer page, Integer rows) {
	Query query = sessionfactory.openSession().createQuery(hql.toString());
	query.setFirstResult((page-1)*rows);
	query.setMaxResults(rows);
	return query.list();
}

public List<StoreType> queryType(StringBuffer hql) {
	Query query = sessionfactory.openSession().createQuery(hql.toString());
	return  query.list();
}

public void addStore(Strore store) {
	sessionfactory.getCurrentSession().saveOrUpdate(store);
	
}

public Strore queryStoreById(Strore store) {

	return  (Strore) sessionfactory.openSession().get(Strore.class,store.getSid());
}

public void deleteStore(StringBuffer hql) {
	sessionfactory.openSession().createQuery(hql.toString()).executeUpdate();
	
}

public void addIns(Instllaction ins) {
	sessionfactory.getCurrentSession().saveOrUpdate(ins);
	
}

public Instllaction queryInsById(Strore store) {

	return  (Instllaction) sessionfactory.openSession().get(Instllaction.class,store.getSid());
}

public List<Strore> queryMyStore() {
	// TODO Auto-generated method stub
	return null;
}

public List<Strore> queryMyStore(StringBuffer hql) {
	// TODO Auto-generated method stub
	return sessionfactory.openSession().createQuery(hql.toString()).list();
}

}
