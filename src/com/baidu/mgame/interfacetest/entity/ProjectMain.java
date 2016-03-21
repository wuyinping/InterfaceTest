package com.baidu.mgame.interfacetest.entity;

import java.util.Date;

/**
 * 项目实体
 *
 * @author maolei
 * @date 2015年8月29日 下午11:04:57
 * @version V1.0
 */
public class ProjectMain implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // Fields
    private int id;
    private String p_name;
    private String p_key;
    private int version;
    private int del_flag;
    private Date mtime;

    // Constructors
    /** default constructor */
    public ProjectMain() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public String getP_name() {
        return this.p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_key() {
        return this.p_key;
    }

    public void setP_key(String p_key) {
        this.p_key = p_key;
    }

}