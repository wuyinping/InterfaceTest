package com.baidu.mgame.interfacetest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具类
 *
 * @author maolei
 * @date 2015年8月30日 下午5:27:43
 * @version V1.0
 */
public class TimeUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String dateFormat(Date date) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }
}
