package com.jk.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class Instllaction {
	@Id
	@GeneratedValue(generator="seq")
	@SequenceGenerator(name="seq",sequenceName="seq_sins_id")
	private Integer iid;
	private Integer sid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date idate;
	@Override
	public String toString() {
		return "Instllaction [iid=" + iid + ", sid=" + sid + ", idate=" + idate + "]";
	}
	public Instllaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Instllaction(Integer iid, Integer sid, Date idate) {
		super();
		this.iid = iid;
		this.sid = sid;
		this.idate = idate;
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	} 
}
