package com.jk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_store")
public class Strore {
@Id
@GeneratedValue(generator="seq")
@SequenceGenerator(name="seq",sequenceName="seq_sto_id")
private Integer sid;
private String sname;
private String simg;
private String steam;
private String sversion;
private Double sscore;
private Integer stype;
private String slanguage;
private String sinfo;
@Override
public String toString() {
	return "Strore [sid=" + sid + ", sname=" + sname + ", simg=" + simg + ", steam=" + steam + ", sversion=" + sversion
			+ ", sscore=" + sscore + ", stype=" + stype + ", slanguage=" + slanguage + ", sinfo=" + sinfo + "]";
}
public Strore() {
	super();
	// TODO Auto-generated constructor stub
}
public Strore(Integer sid, String sname, String simg, String steam, String sversion, Double sscore, Integer stype,
		String slanguage, String sinfo) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.simg = simg;
	this.steam = steam;
	this.sversion = sversion;
	this.sscore = sscore;
	this.stype = stype;
	this.slanguage = slanguage;
	this.sinfo = sinfo;
}
public Integer getSid() {
	return sid;
}
public void setSid(Integer sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSimg() {
	return simg;
}
public void setSimg(String simg) {
	this.simg = simg;
}
public String getSteam() {
	return steam;
}
public void setSteam(String steam) {
	this.steam = steam;
}
public String getSversion() {
	return sversion;
}
public void setSversion(String sversion) {
	this.sversion = sversion;
}
public Double getSscore() {
	return sscore;
}
public void setSscore(Double sscore) {
	this.sscore = sscore;
}
public Integer getStype() {
	return stype;
}
public void setStype(Integer stype) {
	this.stype = stype;
}
public String getSlanguage() {
	return slanguage;
}
public void setSlanguage(String slanguage) {
	this.slanguage = slanguage;
}
public String getSinfo() {
	return sinfo;
}
public void setSinfo(String sinfo) {
	this.sinfo = sinfo;
}
}
