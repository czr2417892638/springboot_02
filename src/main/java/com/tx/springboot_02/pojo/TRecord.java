package com.tx.springboot_02.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * t_record
 * @author 
 */
public class TRecord implements Serializable {
    private Integer id;

    private String name;

    private String stucode;


    private Date createdate;

    private String createby;

    private String des;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStucode() {
        return stucode;
    }

    public void setStucode(String stucode) {
        this.stucode = stucode;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    public TRecord(){}
    public TRecord(Integer id, String name, String stucode, Date createdate, String createby, String des) {
        this.id = id;
        this.name = name;
        this.stucode = stucode;
        this.createdate = createdate;
        this.createby = createby;
        this.des = des;
    }

    public TRecord(String name, String stucode, Date createdate, String createby, String des) {
        this.name = name;
        this.stucode = stucode;
        this.createdate = createdate;
        this.createby = createby;
        this.des = des;
    }

    public TRecord(String name, String stucode, String createby, String des) {
        this.name = name;
        this.stucode = stucode;
        this.createby = createby;
        this.des = des;
    }
}