package com.jk.service;

import com.jk.dao.UserMapper;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements  UserService{
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserMapper userMapper;


    @Override
    public void addUsers(List<User> list) {
        userMapper.addUsers(list);
    }

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public User queryUserByName1(String uname) {
        return userMapper.queryUserByName1(uname);
    }

    @Override
    public Map queryUser(Integer page, Integer rows) {
        int stat=(page-1)*rows;
        long count=userMapper.queryCount();
        List<Tree> list =userMapper.queryUser(stat,rows);
        Map map =new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;

    }

          /*  //判断redis中是否有缓存记录
            key ="login"+reuser.getUid();
            if(redisTemplate.hasKey(key)){
                int  count=	Integer.parseInt((String) redisTemplate.opsForValue().get(key));
                if(count>=3){//用户已被冻结
                    return 5;
                }
            }
        }if(user.getUpwd()!=null  &&!"".equals(user.getUpwd())  && user.getUpwd().equals(reuser.getUpwd()) ){
            session.setAttribute("loginUser", reuser);//登录正确存入session中
            //删除存在redis中的  错误记录次数   的缓存
            redisTemplate.delete(key);
            return 1;//密码正确 登录成功
        }else {//密码错误
            if (!redisTemplate.hasKey(key)) {//不存在key
                //如果不存在  则将key 值设为1
                redisTemplate.opsForValue().set(key, "1");
                redisTemplate.expire(key, 5, TimeUnit.MINUTES);//五分钟之内登录失败三次被锁定
                return 4;
            } else {
                //否则 原来的值 递增1
                Long increment = redisTemplate.opsForValue().increment(key, 1);
                //如果 increment>=3 则用户被锁定
                if (increment >= 3) {
                    redisTemplate.expire(key, 5, TimeUnit.MINUTES);//五分钟之后解锁
                    return 5;
                }//否则 密码错误 return 4
                return 4;
            }
        }*/

/**
 * Copyright (C), 2015-2019, jk
 * FileName: UserServiceImpl
 * Author:   Lemovo
 * Date:     2019-08-09 11:56
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
}

