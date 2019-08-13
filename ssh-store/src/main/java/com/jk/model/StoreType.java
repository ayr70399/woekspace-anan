package com.jk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_storetype")
public class StoreType {
	@Id
	@GeneratedValue(generator="seq")
	@SequenceGenerator(name="seq",sequenceName="seq_stype_id")
	private Integer tid;
	private String tname;
	@Override
	public String toString() {
		return "StoreType [tid=" + tid + ", tname=" + tname + "]";
	}
	public StoreType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreType(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
}
