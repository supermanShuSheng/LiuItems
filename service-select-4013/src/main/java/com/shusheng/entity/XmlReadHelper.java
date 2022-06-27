package com.shusheng.entity;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class XmlReadHelper {


    public static String writeXml(String[] str, List list) {
        Object[] obj = null;
        Document retDoc = null;
        Element root = null;
        Element row = null;
        Element col = null;
        int listlen;
        int strlen = str.length;
        if (strlen > 0) {
            listlen = list.size();
            root = DocumentHelper.createElement("DBSET");//创建根节点
            if (listlen == 0) {
                row = DocumentHelper.createElement("R");
                for (int j = 0; j < strlen; j++) {
                    col = DocumentHelper.createElement("C");
                    col.addAttribute("N", str[j]);
                    col.addText("");
                    row.add(col);
                }
                root.add(row);
            } else {
                for (int i = 0; i < listlen; i++) {
                    row = DocumentHelper.createElement("R");
                    obj = (Object[]) list.get(i);
                    for (int j = 0; j < strlen; j++) {
                        col = DocumentHelper.createElement("C");
                        col.addAttribute("N", str[j]);
                        col.addText(obj[j] == null ? "" : obj[j].toString());
                        row.add(col);
                    }
                    root.add(row);
                }
            }
            retDoc = DocumentHelper.createDocument(root);//创建xml文档，并添加根节点
        }
        return retDoc == null?"":retDoc.asXML();
    }


    public static List readXml(String xmlParam) {
        Hashtable<String, String> xmlTable = null;
        List<Hashtable<String, String>> readXmlList = new ArrayList<Hashtable<String, String>>();
        try {
            Document xmlDocRead = DocumentHelper.parseText(xmlParam);
            Element root = xmlDocRead.getRootElement();
            Element r = null;
            Element c = null;
            List colList = null;
            List rList = root.elements();
            for (int i = 0; i < rList.size(); i++) {
                r = (Element) rList.get(i);
                colList = r.elements();
                xmlTable = new Hashtable<String, String>();
                for (int i_ = 0; i_ < colList.size(); i_++) {
                    c = (Element) colList.get(i_);
                    xmlTable.put(c.attributeValue("N"), c.getText().trim());
                }
                readXmlList.add(xmlTable);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return readXmlList;
    }
    public static List readXml(String xmlParam,String type) {
        Hashtable<String, String> xmlTable = null;
        List<Hashtable<String, String>> readXmlList = new ArrayList<Hashtable<String, String>>();
        try {
            Document xmlDocRead = DocumentHelper.parseText(xmlParam);
            Element root = xmlDocRead.getRootElement();
            Element r = null;
            Element c = null;
            List colList = null;
            List rList = root.elements();
            for (int i = 0; i < rList.size(); i++) {
                r = (Element) rList.get(i);
                colList = r.elements();
                xmlTable = new Hashtable<String, String>();
                for (int i_ = 0; i_ < colList.size(); i_++) {
                    c = (Element) colList.get(i_);
                    xmlTable.put(c.attributeValue("N"), c.getText().trim());
                }
                if("0".equals(type)){
                    if("ap".equals(r.getName().toString())){
                        readXmlList.add(xmlTable);
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return readXmlList;
    }
    public static Hashtable<String, Object> readXml2(String xmlParam) {
        Hashtable<String, Object> res = new Hashtable<String, Object>();
        Hashtable<String, String> xmlTable = null;
        List<Hashtable<String, String>> readXmlList = new ArrayList<Hashtable<String, String>>();
        try {
            Document xmlDocRead = DocumentHelper.parseText(xmlParam);
            Element root = xmlDocRead.getRootElement();
            Element r = null;
            Element c = null;
            List colList = null;
            List rList = root.elements();
            for (int i = 0; i < rList.size(); i++) {
                r = (Element) rList.get(i);
                colList = r.elements();
                xmlTable = new Hashtable<String, String>();
                for (int i_ = 0; i_ < colList.size(); i_++) {
                    c = (Element) colList.get(i_);
                    xmlTable.put(c.attributeValue("N"), c.getText().trim());
                }
//                readXmlList.add(xmlTable);
                if("ap".equals(r.getName().toString())){
                    res.put("ap", xmlTable);
                }
                if("ua".equals(r.getName().toString())){
                    res.put("ua", xmlTable);
                }
                if("ub".equals(r.getName().toString())){
                    res.put("ub", xmlTable);
                }
                if("uc".equals(r.getName().toString())){
                    res.put("uc", xmlTable);
                }
                if("ia".equals(r.getName().toString())){
                    res.put("ia", xmlTable);
                }
                if("ib".equals(r.getName().toString())){
                    res.put("ib", xmlTable);
                }
                if("ic".equals(r.getName().toString())){
                    res.put("ic", xmlTable);
                }
                if("pf_o".equals(r.getName().toString())){
                    res.put("pf_o", xmlTable);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return res;
    }
}
