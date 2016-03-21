package com.baidu.mgame.interfacetest.entity;

import java.util.Date;

/**
 * 项目版本实体
 *
 * @author maolei
 * @date 2015年8月29日 下午11:05:30
 * @version V1.0
 */
public class ProjectVersion implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // Fields
    private int id;
    private int project_id;
    private String version_code;
    private int del_flag;
    private Date mtime;

    // Constructors
    /** default constructor */
    public ProjectVersion() {

    }

    // Property accessors
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return this.project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getVersion_code() {
        return this.version_code;
    }

    public void setVersion_code(String version_code) {
        this.version_code = version_code;
    }

    public int getDel_flag() {
        return this.del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

    public Date getMtime() {
        return this.mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

}