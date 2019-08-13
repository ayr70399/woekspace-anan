package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Store;
import com.jk.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class aa {
/**
 * Copyright (C), 2015-2019, jk
 * FileName: aa
 * Author:   Lemovo
 * Date:     2019-08-06 20:40
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
@Reference
private StoreService storeService;

@RequestMapping("showStore")
public String showStore(){
    return "show";
}
@RequestMapping("queryStore")
    @ResponseBody
    public Map queryStore(Integer page, Integer rows , Store store){
     return  storeService.queryStore(page,rows,store);
}
@RequestMapping("addStoreJsp")
    public String addStoreJsp(){
    return  "add";
}
@RequestMapping("addStore")
    @ResponseBody
    public void addStore(Store  store){
    storeService.addStore(store);
}
@RequestMapping("delStore")
    @ResponseBody
    public void delStore(String delid){
    storeService.delStore(delid);
}
@RequestMapping("queryStoreById")
    public  String queryStoreById(Integer sid, Model model){
    Store  store=storeService.queryStoreById(sid);
    model.addAttribute("store",store);
    return  "upd";
}
@RequestMapping("updStore")
    @ResponseBody
    public void updStore(Store  store){
    storeService.updStore(store);
}
}

