package com.baidu.mgame.interfacetest.vo;

import java.io.Serializable;

/**
 * 公共下行定义
 *
 * @author maolei
 * @date 2015年8月30日 下午2:36:52
 * @version V1.0
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误编码
     */
    private int errorcode = -1;

    /**
     * 错误信息
     */
    private String errormsg = "";

    public int getErrorcode() {
        return this.errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

}
