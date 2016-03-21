/**
 *
 */
package com.baidu.mgame.interfacetest.main;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Scanner;

import com.baidu.mgame.interfacetest.utils.AES;
import com.baidu.mgame.interfacetest.utils.HttpUtil;
import com.baidu.mgame.interfacetest.utils.XMLReader;

/**
 * @Title: MainClass.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author maolei
 * @date 2015年6月5日 下午4:31:59
 * @version V1.0
 */
public class MainClass {

    private final static String XML_PATH = "resources/config.xml";

    private static Map<String, String> skeyMap;
    private static Map<String, Map<String, String>> urlMap;
    private static Map<String, Map<String, String>> tagMap;

    private static String baseUrl;
    private static String servlet;
    private static AES myaes = null;

    private static void initDatas() {
        System.out.println();
        System.out.println("请选择要测试的项目（使用相应的编号）：");
        String[] projects = skeyMap.keySet().toArray(new String[0]);
        for (int i = 0; i < projects.length; i++) {
            System.out.println(i + " -> " + projects[i]);
        }

        Scanner sc = new Scanner(System.in);
        int pro = sc.nextInt();
        String project = projects[pro];

        System.out.println();
        System.out.println("请选择测试环境：");
        Map<String, String> urlTempMap = urlMap.get(project);
        String[] urls = urlTempMap.keySet().toArray(new String[0]);
        for (int i = 0; i < urls.length; i++) {
            System.out.println(i + " -> " + urls[i]);
        }

        int url = sc.nextInt();
        String profile = urls[url];

        // 输入tag
        System.out.println();
        System.out.println("请选择测试接口：");
        Map<String, String> tagTempMap = tagMap.get(project);
        String[] tags = tagTempMap.keySet().toArray(new String[0]);
        for (int i = 0; i < tags.length; i++) {
            // 数字开头的tag号加前缀
            String tmp = tags[i].charAt(0) >= 48 && tags[i].charAt(0) <= 57 ? "tag" : "";
            System.out.println(i + " -> " + tmp + tags[i]);
        }

        int aTag = sc.nextInt();
        String tag = tags[aTag];

        // 是否需要加解密
        System.out.println();
        System.out.println("是否需要加/解密：（0不需要；1需要）");
        int isAes = sc.nextInt();
        boolean aesFlag = 0 == isAes ? false : true;

        // 从Map获取获得相应参数
        String sKey = skeyMap.get(project);

        baseUrl = urlMap.get(project).get(profile);
        servlet = tagMap.get(project).get(tag);
        // 初始化测试加密解密工具类
        if (aesFlag) {
            myaes = new AES(sKey, true);
        }

        System.out.println();
        System.out.println("请输入接口测试上行参数（每次一条，可连续输入多次）：");
        System.out.println("（输入\"ag\"来重新选择测试项目）");
        System.out.println("（输入\"exit\"来退出测试程序）");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 初始化配置文件
        XMLReader xmlReader = new XMLReader();
        try {
            xmlReader.readXML(XML_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 初始化对话框
        skeyMap = xmlReader.getSkeyMap();
        urlMap = xmlReader.getUrlMap();
        tagMap = xmlReader.getTagMap();

        // 初始化数据
        initDatas();

        // 执行接口测试
        String line = null;
        Scanner sc2 = new Scanner(System.in);
        while ((line = sc2.nextLine()) != null && !line.equals("exit")) {
            if (line.trim().equals("")) {
                continue;
            }

            if ("ag".equals(line)) {
                initDatas();
                continue;
            }

            // System.out.println("输入的json字符串（上行参数）：");
            // System.out.println(line);
            // System.out.println("访问的线上服务器：");
            // System.out.println(line);

            String param = null;
            String result = null;
            try {
                param = null != myaes ? myaes.aesEncrypt(line.trim()) : URLEncoder.encode(line.trim(), "UTF-8");
                String sr = HttpUtil.http(baseUrl + servlet, param);
                result = null != myaes ? myaes.aesDecrypt(sr) : URLDecoder.decode(sr, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("接口测试返回的json字符串（下行参数）：");
            System.out.println(result);
            System.out.println();
        }
    }

}
