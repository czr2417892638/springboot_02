package com.tx.springboot_02.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * t_student
 * @author 
 */
public class TStudent implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private Integer major;

    private String grade;

    private Integer sex;

    private Date birthday;

    private Integer tel;

    private Integer job;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }
    public TStudent(){}
    public TStudent(Integer id, String code, String name, Integer major, String grade, Integer sex, Date birthday, Integer tel, Integer job) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.major = major;
        this.grade = grade;
        this.sex = sex;
        this.birthday = birthday;
        this.tel = tel;
        this.job = job;
    }

    public TStudent(String code, String name) {
        this.code = code;
        this.name = name;
    }
}