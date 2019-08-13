package com.jk.interceptor;

import com.jk.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        User user = (User) request.getSession().getAttribute("loginUser");
        System.out.println("======进来拦截器了");
		/*登录成功后把对象放到session中，这里是从session中取值，
		在session中放值是通过request.getSession().setAttribute(key,value);*/
        if(user==null){
            //System.out.println(request.getRequestDispatcher("../index.jsp"));
            response.sendRedirect("../user/LoginJsp");
            /*做一个判断，如果session中取不到值那么就返回这个页面，可以根据实际使用场景自己设置拦截器*/
            return false;
        }else{
            return true;
        }
    }
}
