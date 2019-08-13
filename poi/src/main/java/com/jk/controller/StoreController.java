package com.jk.controller;

import com.jk.model.Store;
import com.jk.service.StoreService;
import com.jk.util.ExportExcel;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {
/**
 * Copyright (C), 2015-2019, jk
 * FileName: StoreController
 * Author:   Lemovo
 * Date:     2019-08-08 16:34
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
@Autowired
    private StoreService storeservice;
@RequestMapping("queryStore")
public String  queryStore(Model model){
    List<Store> list = storeservice.queryStore();
    model.addAttribute("list",list);
    return  "show";
}
@RequestMapping("exportExcel")
public void exportExcel(String name,HttpServletResponse response){
    System.out.println(name);
    String[] rowName =null;
    System.out.println(rowName);
    if(name!=null && !"".equals(name)){
        rowName = name.split(",");
    }else{
        rowName=new String[]{"sid","sname","simg","sinfo","slanguage","stype","sversion"};
    }
    //导出的excel的标题
    String title = "安安专属store管理";
        //导出excel的列名

    //导出的excel数据
    List<Object[]>  dataList = new ArrayList<Object[]>();
    //查询的数据库的书籍信息
    List<Store> stores = storeservice.queryStore();

    //循环书籍信息
    for(Store store:stores){
        Object[] obj =new Object[rowName.length];
        int i=0;



        if(rowName!=null){
            for (int j=0;j<rowName.length;j++){
                obj[0]="id";
        if(rowName[j].contains("sname")){
            i++;
            obj[i]=store.getSname();

        }if(rowName[j].equals("simg")){
                    i++;
            obj[i]=store.getSimg();

        }if(rowName[j].contains("sinfo")){
                    i++;
            obj[i]=store.getSinfo();

        }if(rowName[j].contains("slanguage")){
                    i++;
            obj[i]=store.getSlanguage();

        }if(rowName[j].contains("stype")){
                    i++;
            if(store.getStype()==1){
                obj[i]="手机";
            }else{
                obj[i]="电脑";
            }

        }if(rowName[j].contains("sversion")){
                    i++;
            obj[i]=store.getSversion();

        }
        if(rowName[j].contains("sscore")){
i++;
            obj[i]=store.getSscore();
        }
            }
        }else{
            obj[0]=store.getSname();

            obj[1]=store.getSid();


            obj[2]=store.getSimg();


      //  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        // String format = sdf.format(store.getstoretime());
        //obj[3]=format;
       obj[3]=store.getSinfo();
        obj[4]=store.getSlanguage();
        obj[5]=store.getSscore();
        if(store.getStype()==1){
            obj[6]="手机";
        }else{
            obj[6]="电脑";
        }
        obj[7]=store.getSversion();}
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
    List<Store> list =new ArrayList<Store>();
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
              Store store =new Store();
                //获得每一行的数据
                Row row = sheetAt.getRow(j);

             //获得每一个单元格的数据
                if(row.getCell(1)!=null && !"".equals(row.getCell(1))){
                    store.setSname(this.getCellValue(row.getCell(1)));
                }
                if(row.getCell(2)!=null && !"".equals(row.getCell(2))){
                    System.out.println(row.getCell(2));
                    store.setSimg(this.getCellValue(row.getCell(2)));
                }
                if(row.getCell(3)!=null && !"".equals(row.getCell(3))){
                    store.setSinfo(this.getCellValue(row.getCell(3)));
                }
                if(row.getCell(4)!=null && !"".equals(row.getCell(4))){
                    store.setSlanguage(this.getCellValue(row.getCell(4)));
                }
             if(row.getCell(5)!=null && !"".equals(row.getCell(5))){
                 String cellValue = this.getCellValue(row.getCell(5));
                 if("手机".equals(cellValue)){
                     store.setStype(1);
                 }else{
                     store.setStype(2);
                 }
                }

           if(row.getCell(6)!=null && !"".equals(row.getCell(6))){
               System.out.println(row.getCell(6));
               store.setSscore(Double.parseDouble(this.getCellValue(row.getCell(6))));
                }
            if(row.getCell(7)!=null && !"".equals(row.getCell(7))){
                store.setSversion(this.getCellValue(row.getCell(7)));
            }
                list.add(store);
            }
        }
       storeservice.addStores(list);

    } catch (Exception e) {
        e.printStackTrace();
    }


    return "show";
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

