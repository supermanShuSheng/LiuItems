package com.shusheng.domain;

import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：dxf
 * @date ：2021/3/10 14:21
 */
public class Card {
        //卡号
      private String cardId;
      //名称
      private String cardName;
      //地址
      private String addr;
      //电话
      private String mobile;
      //卡类型
      private String cardType;
      //部门ID
      private String deptId;
      //部门名称
      private String orgName;
      //登录账号ID
      private String userId;

      private List<Card> child;

    public Card() {
    }

    public Card(String cardId, String cardName, String addr, String mobile, String cardType, String deptId, String orgName, String userId, List<Card> child) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.addr = addr;
        this.mobile = mobile;
        this.cardType = cardType;
        this.deptId = deptId;
        this.orgName = orgName;
        this.userId = userId;
        this.child = child;
    }

    public String getOldCardName(){
        return cardName;
    }
    public String getOldAddr(){
        return addr;
    }
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return userNameTM(this.cardName);
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getAddr() {
        return addrTM(addr);
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Card> getChild() {
        return child;
    }

    public void setChild(List<Card> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", cardName='" + cardName + '\'' +
                ", addr='" + addr + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cardType='" + cardType + '\'' +
                ", deptId='" + deptId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", userId='" + userId + '\'' +
                ", child=" + child +
                '}';
    }


    /**
     * 用户名脱敏
     * @param userName
     * @return
     */
    private String userNameTM(String userName){
        try {
            if (StringUtils.isBlank(userName)) {  // 全空的不处理；
                return userName;
            }
            userName = userName.replaceAll(" ", ""); //剔除空格
            if (wordCound(userName) == 0) {
                userName = "**" + (userName.length() < 3?"":userName.substring(2));  //全部是数字或字符的，没有汉字的从头取2个汉字替换为*；【29-1-6-1】- -》【**-1-6-1】
            } else if (userName.length() >= 8) {  //长度>=8个汉字的从两头各取2个汉字替换为*；【江西省交通工程集团有限公司LJ10标项目部】- -》【**省交通工程集团有限公司LJ10标项**】
                userName = "**" + userName.substring(2, userName.length() - 2) + "**";
            } else {  //长度<8个汉字的从头取1个汉字替换为*；【何伟】- -》【*伟】 其他
                userName = "*" + (userName.length() < 2 ? "" : userName.substring(1));
            }
        }catch (Exception e){
            System.out.println("姓名异常"+userName);
        }
        return userName;
    }

    /**
     * 地址脱敏
     * @param addr
     * @return
     */
    private String addrTM(String addr){
        try {
            if (StringUtils.isBlank(addr)) {  // 全空的不处理；
                return addr;
            }
            addr = addr.replaceAll(" ", "");
            if ((wordCound(addr) == 0 && addr.length() >= 6) || (wordCound(addr) == addr.length() && addr.length() >= 8)) {
              /*
            全部是数字或字符的，没有汉字的长度在6个及以上的则两头各取2替换为*；【3-1-5-1】- -》 【**1-5**】
            或
            没有数字的长度大于8个汉字的从两头各取2个汉字替换为*；【五通桥区中心路香枫丽城御院】- -》【**桥区中心路香枫丽城**】
             */
                addr = "**" + addr.substring(2, addr.length() - 2) + "**";
            } else if ((wordCound(addr) == 0 && addr.length() < 6) || (wordCound(addr) == addr.length() && addr.length() < 4)) {
            /* 全部是数字或字符的，没有汉字的长度在6个以下的则从头取1替换为*；【9-2-1】- -》 【*-2-1】
            或
             没有数字的长度小于4个汉字的从头取1个汉字替换为*；【滨河路】- -》 【*河路】
            **/
                addr = "*" + addr.substring(1);
            } else if (wordCound(addr) == addr.length() && addr.length() >= 4 && addr.length() < 8) { //没有数字的长度在4~~8个汉字的从两头各取1个汉字替换为*； 【南华宫商业街】- -》 【*华宫商业*】
                addr = "*" + addr.substring(2, addr.length() - 2) + "*";
            } else {
                //数字前面的2个汉字且不为数字或字符的替换为*；【滨河路666号  1-1-14-2】- -》【滨**666*1-1-14-2】
                addr = addr.substring(0, wordCound(addr) < 2 ? 0 : wordCound(addr) - 2) + "**" + addr.substring(wordCound(addr));
            }
        }catch (Exception e){
            System.out.println("地址异常："+addr);
        }
        return addr;
    }


    /**
     * 统计中文个数
     * @param word
     * @return
     */
    private int wordCound(String word){
        int count=0;

        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");

        char[] c = word.toCharArray();

        for(int i=0;i<c.length;i++){

        Matcher matcher = pattern.matcher(String.valueOf(c[i]));

        if(matcher.matches()){
            count++;
        }

    }

    return count;
    }

}
