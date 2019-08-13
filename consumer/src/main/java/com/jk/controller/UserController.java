package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.CheckImgUtil;
import com.jk.util.ExportExcel;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userservice;
/**
 * Copyright (C), 2015-2019, jk
 * FileName: UserController
 * Author:   Lemovo
 * Date:     2019-08-09 17:17
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
        System.out.println(attribute);
        int  flag=0;
        //首先判断验证码
        if(attribute.toLowerCase()!=null && !"".equals(attribute.toLowerCase()) && attribute.toLowerCase().equals(checkcode.toLowerCase())){
            User reuser=userservice.queryUserByName1(user.getUname());
            System.out.println(user.getUname());
            if(reuser!=null){
                if(user.getUpwd()!=null  &&!"".equals(user.getUpwd())  && user.getUpwd().equals(reuser.getUpwd()) ){
                    session.setAttribute("loginUser",reuser);
                    return 1;
                }else{
                    return  4;
                }
            }else{
                return 3;
            }
        }else{
            flag = 2;// 验证码错误
        }
session.setAttribute("flag",flag);
        return flag;
    }
@RequestMapping("queryUserJsp")
    public String queryUserJsp(){
    return "showuserjsp";
}
@RequestMapping("queryUser")
    @ResponseBody
    public Map queryUser(Integer page, Integer rows){
    return  userservice.queryUser(page,rows);
}
    @RequestMapping("exportExcel")
    public void exportExcel(String name,HttpServletResponse response){
        System.out.println(name);
        String[] rowName =null;
        System.out.println(rowName);
        if(name!=null && !"".equals(name)){
            rowName = name.split(",");
        }else{
            rowName=new String[]{"sid","sname","pwd"};
        }
        //导出的excel的标题
        String title = "安安专属store管理";
        //导出excel的列名

        //导出的excel数据
        List<Object[]> dataList = new ArrayList<Object[]>();
        //查询的数据库的书籍信息
        List<User> stores = userservice.queryUserList();

        //循环书籍信息
        for(User user :stores){
            Object[] obj =new Object[rowName.length];
            int i=0;



            if(rowName.length>=2){
                for (int j=0;j<rowName.length;j++){
                    obj[0]="id";
                    if(rowName[j].contains("sname")){
                        i++;
                        obj[i]=user.getUname();

                    }if(rowName[j].equals("simg")){
                        i++;
                        obj[i]=user.getUpwd();

                    }
                }
            }else{
                obj[0]=user.getUname();

                obj[1]=user.getUname();


                obj[2]=user.getUpwd();


             }
            dataList.add(obj);
        }
        ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file, HttpServletResponse response){
        //获得上传文件上传的类型
        String contentType = file.getContentType();
        //上传文件的名称
        String fileName = file.getOriginalFilename();
        //获得文件的后缀名
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件的新的路径
        //生成新的文件名称
        String filePath = "./src/main/resources/templates/fileupload/";
        //创建list集合接收excel中读取的数据
        List<User> list =new ArrayList<User>();
        try {
            uploadFile(file.getBytes(), filePath, fileName);
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            //通过文件忽的WorkBook
            FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            //通过workbook对象获得sheet页 有可能不止一个sheet
            for(int i=0 ;i<workbook.getNumberOfSheets();i++){
                //获得里面的每一个sheet对象
                Sheet sheetAt = workbook.getSheetAt(i);
                //通过sheet对象获得每一行
                for(int j=3;j<sheetAt.getPhysicalNumberOfRows();j++){
                    //创建一个book对象接收excel的数据
                   User user =new User();
                    //获得每一行的数据
                    Row row = sheetAt.getRow(j);

                    //获得每一个单元格的数据
                    if(row.getCell(1)!=null && !"".equals(row.getCell(1))){
                        user.setUname(this.getCellValue(row.getCell(1)));
                    }
                    if(row.getCell(2)!=null && !"".equals(row.getCell(2))){
                        System.out.println(row.getCell(2));
                        user.setUpwd(this.getCellValue(row.getCell(2)));
                    }

                    list.add(user);
                }
            }
            userservice.addUsers(list);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "showTreeJsp";
    }
    //上传文件的方法
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(Cell cell){
        String value = null;
        //简单的查检列类型
        switch(cell.getCellType())
        {
            case Cell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC://数字
                long dd = (long)cell.getNumericCellValue();
                value = dd+"";
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                break;
        }
        return value;
    }
}

