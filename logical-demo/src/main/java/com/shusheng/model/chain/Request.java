package com.shusheng.model.chain;

/**
 * @author 刘闯
 * @date 2021/7/20.
 */
public class Request {

    private RequestType type;
    private String name;


    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }


    public RequestType getType() {
        return type;
    }


    public String getName() {
        return name;
    }
}
