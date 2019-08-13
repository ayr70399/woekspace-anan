/** 
 * <pre>项目名称:demo 
 * 文件名称:LogController.java 
 * 包名:com.jk.log.controller 
 * 创建日期:2019年7月12日下午5:20:08 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import com.jk.model.Log;
import com.jk.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
@Controller
@RequestMapping("log")
public class LogController {
@Autowired
private LogService logservice;
@RequestMapping("showLogJsp")
public String showLogJsp(){
	return "showlog";
}
@RequestMapping("queryLog")
@ResponseBody
public Map queryLog(Integer page,Integer rows){
	return logservice.queryLog(page,rows);
}
@RequestMapping("addLogJsp")
public String addLogJsp(){
	return "addlog";
}
@RequestMapping("addLog")
@ResponseBody
public void addLog(Log log){
	logservice.addLog(log);
}
@RequestMapping("queryLogById")
public String queryLogById(String id,Model model){
	Log log=logservice.queryLogById(id);
	model.addAttribute("log", log);
	return "updlog";
}
@RequestMapping("updLog")
@ResponseBody
public  void updLog(Log log){
	logservice.updLog(log);
}
@RequestMapping("delLog")
@ResponseBody
public void delLog(String [] delid){
	logservice.delLog(delid);
}
}
