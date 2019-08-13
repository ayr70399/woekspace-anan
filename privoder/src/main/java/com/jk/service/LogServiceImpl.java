/** 
 * <pre>项目名称:demo 
 * 文件名称:LogServiceImpl.java 
 * 包名:com.jk.log.service 
 * 创建日期:2019年7月12日下午5:20:59 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import com.jk.model.Log;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="logService")
public  class LogServiceImpl implements LogService {
	@Resource
private MongoTemplate mongoTemplate;

/* (non-Javadoc)    
 * @see com.jk.log.service.LogService#queryLog(com.jk.log.model.Log, java.lang.Integer, java.lang.Integer)    
 */
public Map queryLog(Integer page, Integer rows) {
	Query query=new Query();
		long count = mongoTemplate.count(query,Log.class,"log");

		   query.skip((page-1)* rows);
		   query.limit(rows);
		List<Log> list = mongoTemplate.find(query, Log.class,"log");
		Map map=new HashMap();
		map.put("rows", list);
		map.put("total", count);
		return map;
}

/* (non-Javadoc)    
 * @see com.jk.log.service.LogService#queryLogById(java.lang.String)    
 */
public Log queryLogById(String id) {
	Criteria cri=new Criteria();
	org.springframework.data.mongodb.core.query.Query query =new org.springframework.data.mongodb.core.query.Query();;
	cri.and("_id").is(id);
	query.addCriteria(cri);
	return mongoTemplate.findOne(query, Log.class, "log");
}

/* (non-Javadoc)    
 * @see com.jk.log.service.LogService#addLog(com.jk.log.model.Log)    
 */
public void addLog(Log log) {
	mongoTemplate.insert(log, "log");
}

/* (non-Javadoc)    
 * @see com.jk.log.service.LogService#updLog(com.jk.log.model.Log)    
 */
public void updLog(Log log) {
	Update update =new Update();
	Query query=new Query();
if(log.getLname()!=null && !"".equals(log.getLname())){
		update.set("lname", log.getLname());
	}if(log.getLtime()!=null){
		update.set("ltime", log.getLtime());
	}
	Criteria cri=new Criteria();

	cri.and("_id").is(log.getId());
	mongoTemplate.updateFirst(query, update, "log");
}

/* (non-Javadoc)    
 * @see com.jk.log.service.LogService#delLog(java.lang.String[])    
 */
public void delLog(String[] delid) {
	Criteria  cri=new Criteria();
	 cri.and("_id").in(delid);
	 Query  query =new  Query();
	 query.addCriteria(cri);
	mongoTemplate.remove(query,Log.class, "log");
	
}
}
