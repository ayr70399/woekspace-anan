/** 
 * <pre>项目名称:demo 
 * 文件名称:LogService.java 
 * 包名:com.jk.log.service 
 * 创建日期:2019年7月12日下午5:20:43 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import com.jk.model.Log;

import java.util.Map;

public interface LogService {
	Map queryLog(Integer page, Integer rows);

	Log queryLogById(String id);

	void addLog(Log log);

	void updLog(Log log);

	void delLog(String[] delid);

}
