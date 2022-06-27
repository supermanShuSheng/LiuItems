package com.shusheng.demo;

import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/18.
 */
@Data
public class AAA {
    private String aaaName;
    private String aaaAge;
    private BBB bbb;




    @Data
    class BBB{
        private String bbbName;
        private String bbbAge;
    }
}
