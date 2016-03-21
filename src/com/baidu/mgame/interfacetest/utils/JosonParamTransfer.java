/**
 *
 */
package com.baidu.mgame.interfacetest.utils;

import java.util.Scanner;

/**
 * @Title: JosonParamTransfer.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author maolei
 * @date 2015年5月14日 下午6:59:38
 * @version V1.0
 */
public class JosonParamTransfer {

    /**
     * 进行上行参数的转换
     *
     * @param param
     * @return
     */
    public static String transfer(String param) {
        if (null == param || param.trim().length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            char ch = param.charAt(i);
            if (ch != '"') {
                sb.append(ch);
            } else {
                sb.append("\\\"");
            }
        }

        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待转换的json字符串：");
        String line = null;
        while ((line = sc.nextLine()) != null && !line.equals("")) {
            System.out.println("输入的json字符串：" + line);
            System.out.print("转换后的json字符串：" + transfer(line));
        }
    }

}
