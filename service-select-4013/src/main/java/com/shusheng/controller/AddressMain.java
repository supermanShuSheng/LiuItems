package com.shusheng.controller;

import com.shusheng.entity.XmlReadHelper;
import com.shusheng.utils.CommUtils;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/8/19.
 */
public class AddressMain {
    public static void main(String[] args) {
        List<String> listStrings = getListStrings("ap", "20210617", "22250109305", "http://10.255.238.34:19011/xsgl/serverCode/services/");
        System.out.println("listStrings = " + listStrings);
    }

    /**
     *
     * @param type 类型   例：ap：功率曲线； ia：电流A相； ib：电流B相； ic：电流C相； ua：电压A相； ub：电压B相； uc：电压C相； pf_o：功率因数。
     * @param date 日期  格式：yyyyMMdd
     * @param rowKey sg_code+电能表ID     22250092718
     * @param url  例http://10.255.238.34:19011/xsgl/serverCode/services/
     * @return  List数组
     */
    public static List<String> getListStrings(String type, String date, String rowKey, String url) {
        List<String> result = new ArrayList<>();
        url = url.concat("IService?wsdl");
        // 组装URL为   http://10.255.238.34:19011/xsgl/serverCode/services/IService?wsdl
        try {
            URL _url = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)_url.openConnection();
            httpURLConnection.setReadTimeout(2000);
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.connect();
            Client client = new Client(httpURLConnection.getInputStream(), null);


            // 设置发送时间超时
            client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, String.valueOf(110000));
            client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
            client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,"true");
            Object[] results = client.invoke("getDataFromPro",new Object[] { type,rowKey.substring(2),date});
            if("no data".equals(results[0].toString())){
                return result;
            }else{
                Hashtable<String, Object> res = XmlReadHelper.readXml2(results[0].toString());
                Hashtable<String, Object> xmltable = (Hashtable<String, Object>) res.get(type);
                for(int i = 0;i < 96;i++){
                    String d = (String) xmltable.get("D"+(i+1));
                    if(CommUtils.checkMap(d) != null){
//                        if(i%4 == 0){
                        result.add(d);
//                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("接口调用异常："+e.getMessage());
        }
        return result;
    }
}
