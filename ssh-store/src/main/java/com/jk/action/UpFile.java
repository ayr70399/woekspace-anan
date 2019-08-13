package com.jk.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;



public class UpFile {
	// 上传文件
	public static String upFile(File upImg,String upImgFileName, String dir){
		//==========
				BufferedInputStream in = null;// 输入的流
				BufferedOutputStream out = null;// 输出流
				String imgPath = "";
				try {
					// 构建读取流
					in = new BufferedInputStream(new FileInputStream(upImg) );
					// 构建输出流
						// 1. 获得 项目的真实路径   (重点 )
						String newPath = ServletActionContext.getServletContext().getRealPath(dir);
						// 2. 生成新的文件名 (保证文件名唯一性  保证不被覆盖掉)
						String newFileName = UUID.randomUUID().toString()+"_"+upImgFileName;
						// 3. 生成文件夹
						File mulu = new File(newPath);
						if(!mulu.exists()){// 先判断 目录是否存在
							mulu.mkdir(); // 新建
						}
						// 4. 构建输出流
						out = new BufferedOutputStream(new FileOutputStream(newPath+"\\"+newFileName));
					// 复制文件
					byte[] b = new byte[10240];
					int s = 0;
					while((s=in.read(b))!=(-1)){
						out.write(b);
					}
					imgPath = dir+"/"+newFileName; // 这个路径是个相对路径   应该是存到数据库的路径
					//   新建文件夹得名称 + 图片的新名称
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					try {
						if(in!=null){
							in.close();
						}
						if(out!=null){
							out.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return imgPath;
	}
	
	
	// 下载文件
	public static void downFile(String imgPath){
		// 1. 获得文件的真实路径
		String newPath = ServletActionContext.getServletContext().getRealPath(imgPath);
		// 2. 实例化 文件对象  
		File f = new File(newPath);
		// 3. 获得文件名
		String fileName = f.getName();
		// 4. 定义输入输出流‘
		
		
		
		 
		BufferedInputStream buffIn = null;
		BufferedOutputStream buffOut = null;
		try {
			// 5. 获得输入流
			buffIn = new BufferedInputStream(new FileInputStream(f));
			// 6. 获得 response  和  request (获得 request 和 response )
			HttpServletResponse response  = ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			// 7. 获得输入流       response.getOutputStream() 是servlet的输出流  浏览器的输出流
			buffOut = new BufferedOutputStream(response.getOutputStream());
			
			// 8. 对浏览器进行设置========================================================
			//解决浏览器兼容问题
	        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
	        	fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
	        } else {
	        	// 对文件名进行编码处理中文问题
	        	fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
	        	fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
	        }
	        response.reset();
	        response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型
		     // inline在浏览器中直接显示，不提示用户下载
		        // attachment弹出对话框，提示用户进行下载保存本地
		        // 默认为inline方式
	        response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			//==========================================================================
			// 9. 循环 读写 赋值
			byte[] b = new byte[1024];
			int s = 0;
			while((s=buffIn.read(b))!=(-1)){
				buffOut.write(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(buffIn!=null){
					buffIn.close();
				}
				if(buffOut!=null){
					buffOut.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	} 
	
}
