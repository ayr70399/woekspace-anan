package com.jk.action;

import com.alibaba.fastjson.JSON;
import com.jk.model.StoreType;
import com.jk.model.Strore;
import com.jk.service.StoreService;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Action("StoreAction")
@Results({
	@Result(name="show" ,location="/WEB-INF/store/showstore.jsp"),
	@Result(name="addjsp",location="/WEB-INF/store/addstore.jsp"),
	@Result(name="upd",location="/WEB-INF/store/updstore.jsp"),
	@Result(name="mystore",location="/WEB-INF/store/mystore.jsp"),
	@Result(name="redi",type="redirect",location="/StoreAction!queryMyStore.action")
})
public class StoreAction extends BaseAction  implements  ModelDriven<Strore>{
	@Autowired
private StoreService storeservice;
	private Integer page;
	private Integer rows;
	private File upFile;
	
	private String upFileFileName;
private Strore store=new Strore();
public String show(){
	return "show";
}
public void queryStore(){
	List<Strore> list=storeservice.queryStore(page,rows,store);
	long  count =storeservice.queryCount();
	Map map =new HashMap<String, Object>();
	map.put("rows", list) ;
	map.put("total", count);
	BaseAction.responseWriter(JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd"));
}
public void upFile(){
	String upFile2 = UpFile.upFile(getUpFile(), getUpFileFileName(), "/stuImg");
	BaseAction.responseWriter(upFile2);
}
public String addStoreJsp(){
	return "addjsp";
}
public void addIns(){
	int flag=storeservice.queryIns(store);
	BaseAction.responseWriter(flag+"");
}
public String  queryStoreById(){
	Strore store1=storeservice.queryStoreById(store);
	System.out.println(store1);
	HttpServletRequest request = ServletActionContext.getRequest();
	request.setAttribute("store1", store1);
	return "upd";
}
public void queryType(){
	List<StoreType> list = storeservice.storeservice();
	BaseAction.responseWriter(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd"));
}
private String delid;
public void deleteStore(){
	storeservice.deleteStore(delid);
}
public String  queryMyStore(){
	List<Strore> list=storeservice.queryMyStore();
	HttpServletRequest request = ServletActionContext.getRequest();
	request.setAttribute("list",list);
	return "mystore";
}
private Integer iid;
public String delIns(){
	storeservice.delIns(iid);
	return "redi";
}
public void addStore(){
	storeservice.addStore(store);
}
	public Strore getModel() {
	
		return store;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public Integer getRows() {
		return rows;
	}



	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public File getUpFile() {
		return upFile;
	}
	public void setUpFile(File upFile) {
		this.upFile = upFile;
	}
	public String getUpFileFileName() {
		return upFileFileName;
	}
	public void setUpFileFileName(String upFileFileName) {
		this.upFileFileName = upFileFileName;
	}
	public String getDelid() {
		return delid;
	}
	public void setDelid(String delid) {
		this.delid = delid;
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}

}
