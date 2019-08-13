package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.CheckImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Reference
    private UserService userservice;

/**
 * Copyright (C), 2015-2019, jk
 * FileName: UserController
 * Author:   Lemovo
 * Date:     2019-08-09 12:24
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
@RequestMapping("LoginJsp")
    public String LoginJsp(){
    return "login";
}


    @RequestMapping("checkImg")
    public void checkImg(HttpServletRequest request  , HttpServletResponse response){


        CheckImgUtil.buildCheckImg(request, response);
    }
    @RequestMapping("LoginUser")
    @ResponseBody
    public  int LoginUser(String checkcode, User user , HttpServletRequest   request, HttpSession session){
        String attribute = (String) request.getSession().getAttribute("checkcode");
        if(attribute!=null && !"".equals(attribute) &&  attribute.toLowerCase().equals(checkcode.toLowerCase())){
            try {
                User reUser = userservice.queryUserByName(user.getUname());
                if(reUser==null){
                    return 3;//查无此人
                }else{
                    //此时证明有次用户，判断密码
                    if (user.getUpwd() != null && !"".equals(user.getUpwd()) && user.getUpwd().equals(reUser.getUpwd())) {
                        //此时登录成功
                        session.setAttribute("loginUser",reUser);
                        return 1;//登录成功
                    }else{
                        return 2;//密码错误
                    }
                }
            }catch (Exception NullPointerException){
                return 3;
            }
        }else{
            return 7;//验证码错误
        }
    }

}
