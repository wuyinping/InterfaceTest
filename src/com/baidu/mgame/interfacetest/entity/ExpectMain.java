package com.baidu.mgame.interfacetest.entity;

import java.util.Date;

/**
 * 用例期望结果实体
 * 
 * @author maolei
 * @date 2015年8月29日 下午11:02:32
 * @version V1.0
 */
public class ExpectMain implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // fields
    private int id;
    private int usecase_id;
    private String expect;
    private int del_flag;
    private Date mtime;

    // Constructors
    /** default constructor */
    public ExpectMain() {

    }

    // Property accessors
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsecase_id() {
        return this.usecase_id;
    }

    public void setUsecase_id(int usecase_id) {
        this.usecase_id = usecase_id;
    }

    public String getExpect() {
        return this.expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
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