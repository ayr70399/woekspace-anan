package com.jk.controller;

import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("demo")
public class BookController {
/**
 * Copyright (C), 2015-2019, jk
 * FileName: BookController
 * Author:   Lemovo
 * Date:     2019-08-12 19:14
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
@Autowired
    private BookService bookservice;
@RequestMapping("demo1")
    public String demo1(){
    return "demo1";
}
@RequestMapping("queryDemo1")
    @ResponseBody
    public List<Map<String,Object>> queryDemo1(){
    List<Map<String,Object>> list= bookservice.queryDemo1();
    List<Map<String,Object>> list1=new ArrayList<>();
  for(Map<String,Object> map1 :list){
        Map<String,Object> map =new HashMap<>();
        map.put("name",map1.get("日期"));
        map.put("y", map1.get("总个数"));
        map.put("sliced",true);
        map.put("selected",true);

        list1.add(map);
    }

    return list1;
}
    @RequestMapping("demo2")
    public String demo2(){
        return "demo2";
    }
    @RequestMapping("queryDemo2")
    @ResponseBody
    public List<Map<String,Object>> queryDemo2(){
        List<Map<String,Object>> list= bookservice.queryDemo2();
        List<Map<String,Object>> list1=new ArrayList<>();
        for(Map<String,Object> map1 :list){
            Map<String,Object> map =new HashMap<>();
            map.put("name",map1.get("月份"));
            map.put("y", map1.get("总个数"));
            list1.add(map);
        }
        return list1;
    }
    @RequestMapping("demo3")
    public String demo3(){
        return "demo3";
    }
    @RequestMapping("queryDemo3")
    @ResponseBody
    public List<Map<String,Object>> queryDemo3(){
        List<Map<String,Object>> list= bookservice.queryDemo3();
        List<Map<String,Object>> list1=new ArrayList<>();
        for(Map<String,Object> map1 :list){
            Map<String,Object> map =new HashMap<>();
            map.put("name",map1.get("日期"));
            map.put("y", map1.get("总个数"));
            list1.add(map);
        }
        return list1;
    }
    @RequestMapping("demo4")
    public String demo4(){
        return "demo4";
    }
    @RequestMapping("demo5")
    public String demo5(){
        return "demo5";
    }
}

