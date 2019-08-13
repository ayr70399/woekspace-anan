package com.jk.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = -4771098993214285257L;

	public static void responseWriter(String jsonStr){
		//获取 response
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置编码格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			//获取 响应  写出流
			writer = response.getWriter();
			//将查询到的数据通过流回写到  ajax 回调函数中
			writer.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer.flush();
				writer.close();
			}
		}
	}
}
