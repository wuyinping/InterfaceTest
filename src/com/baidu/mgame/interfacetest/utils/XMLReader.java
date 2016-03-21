/**
 *
 */
package com.baidu.mgame.interfacetest.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @Title: XMLReader.java
 * @author maolei
 * @date 2015年6月8日 下午4:10:09
 * @version V1.0
 */
public class XMLReader {

    /**
     * 用于记录加密key key-项目名；value-加密key
     */
    private final Map<String, String> skeyMap = new HashMap<String, String>();

    /**
     * 用于记录加密key key-项目名；value-tagMap tagMap：key-环境标识;value-url
     */
    private final Map<String, Map<String, String>> urlMap = new HashMap<String, Map<String, String>>();

    /**
     * 用于记录加密key key-项目名；value-tagMap tagMap：key-tag;value-servlet
     */
    private final Map<String, Map<String, String>> tagMap = new HashMap<String, Map<String, String>>();

    /**
     * 解析XML配置文件
     *
     * @param filename
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void readXML(String filename) throws ParserConfigurationException, SAXException, IOException {
        if (null == filename || filename.trim().length() == 0) {
            return;
        }

        // step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // step 2:获得具体的dom解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        // step3: 解析一个xml文档，获得Document对象（根结点）
        Document document = db.parse(new File(filename));

        // step4：遍历解析xml
        Element root = (Element) document.getElementsByTagName("interfaceTest").item(0);

        // 解析加密key
        Element sKeys = (Element) root.getElementsByTagName("sKeys").item(0);
        NodeList keys = sKeys.getElementsByTagName("skey");
        for (int i = 0; i < keys.getLength(); i++) {
            Element element = (Element) keys.item(i);
            this.skeyMap.put(element.getAttribute("project"), element.getAttribute("key"));
        }

        // 解析各个部署环境
        Element deploys = (Element) root.getElementsByTagName("deploys").item(0);
        NodeList deploy = deploys.getElementsByTagName("deploy");
        for (int i = 0; i < deploy.getLength(); i++) {
            Element element = (Element) deploy.item(i);
            Map<String, String> tempMap = new HashMap<String, String>();
            this.urlMap.put(element.getAttribute("project"), tempMap);

            NodeList urls = element.getElementsByTagName("url");
            for (int j = 0; j < urls.getLength(); j++) {
                Element url = (Element) urls.item(j);
                tempMap.put(url.getAttribute("name"), url.getAttribute("baseUrl"));
            }
        }

        // 解析tag信息
        Element tags = (Element) root.getElementsByTagName("tags").item(0);
        NodeList tag = tags.getElementsByTagName("tag");
        for (int i = 0; i < tag.getLength(); i++) {
            Element element = (Element) tag.item(i);
            Map<String, String> tempMap = new HashMap<String, String>();
            this.tagMap.put(element.getAttribute("project"), tempMap);

            NodeList aTags = element.getElementsByTagName("aTag");
            for (int j = 0; j < aTags.getLength(); j++) {
                Element aTag = (Element) aTags.item(j);
                tempMap.put(aTag.getAttribute("code"), aTag.getAttribute("servlet"));
            }
        }
    }

    public Map<String, String> getSkeyMap() {
        return this.skeyMap;
    }

    public Map<String, Map<String, String>> getUrlMap() {
        return this.urlMap;
    }

    public Map<String, Map<String, String>> getTagMap() {
        return this.tagMap;
    }

}
