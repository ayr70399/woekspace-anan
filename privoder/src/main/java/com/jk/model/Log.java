package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private String id;

    private String lname;
@DateTimeFormat(pattern="yyyy-MM-dd")
@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date ltime;

    private String linfo;
    private String patternurl;
    private Integer userid;
    private  String logip;
    private Integer flag;
private  String starttime;
private String endtime;
    public String getStarttime() {
	return starttime;
}

public void setStarttime(String starttime) {
	this.starttime = starttime;
}

public String getEndtime() {
	return endtime;
}

public void setEndtime(String endtime) {
	this.endtime = endtime;
}

	

	

	public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

	public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    public String getLinfo() {
        return linfo;
    }

    public void setLinfo(String linfo) {
        this.linfo = linfo == null ? null : linfo.trim();
    }

	public String getPatternurl() {
		return patternurl;
	}

	public void setPatternurl(String patternurl) {
		this.patternurl = patternurl;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getLogip() {
		return logip;
	}

	public void setLogip(String logip) {
		this.logip = logip;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}