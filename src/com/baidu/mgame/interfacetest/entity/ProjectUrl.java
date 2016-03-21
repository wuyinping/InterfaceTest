package com.baidu.mgame.interfacetest.entity;

import java.util.Date;

/**
 * 项目环境地址实体
 *
 * @author maolei
 * @date 2015年8月29日 下午11:05:14
 * @version V1.0
 */
public class ProjectUrl implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // Fields
    private int id;
    private int project_id;
    private String base_url;
    private String url_name;
    private int del_flag;
    private Date mtime;

    // Constructors
    /** default constructor */
    public ProjectUrl() {

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

    public String getBase_url() {
        return this.base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getUrl_name() {
        return this.url_name;
    }

    public void setUrl_name(String url_name) {
        this.url_name = url_name;
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