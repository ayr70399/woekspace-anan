package com.jk.model;

import java.io.Serializable;

public class Store implements Serializable {
    private Integer sid;

    private String simg;

    private String sinfo;

    private String slanguage;

    private String sname;

    private Double sscore;

    private String steam;

    private Integer stype;

    private String sversion;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg == null ? null : simg.trim();
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo == null ? null : sinfo.trim();
    }

    public String getSlanguage() {
        return slanguage;
    }

    public void setSlanguage(String slanguage) {
        this.slanguage = slanguage == null ? null : slanguage.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Double getSscore() {
        return sscore;
    }

    public void setSscore(Double sscore) {
        this.sscore = sscore;
    }

    public String getSteam() {
        return steam;
    }

    public void setSteam(String steam) {
        this.steam = steam == null ? null : steam.trim();
    }

    public Integer getStype() {
        return stype;
    }

    public void setStype(Integer stype) {
        this.stype = stype;
    }

    public String getSversion() {
        return sversion;
    }

    public void setSversion(String sversion) {
        this.sversion = sversion == null ? null : sversion.trim();
    }
}