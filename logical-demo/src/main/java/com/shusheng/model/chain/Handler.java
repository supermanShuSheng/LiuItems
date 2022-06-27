package com.shusheng.model.chain;

/**
 * 责任链
 * @author 刘闯
 * @date 2021/7/20.
 */
public abstract class Handler {

    protected Handler successor;


    public Handler(Handler successor) {
        this.successor = successor;
    }


    protected abstract void handleRequest(Request request);
}
