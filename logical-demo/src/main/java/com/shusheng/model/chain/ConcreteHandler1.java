package com.shusheng.model.chain;

/**
 * @author 刘闯
 * @date 2021/7/20.
 */
public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler successor) {
        super(successor);
    }


    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE1) {
            System.out.println(request.getName() + " is handle by ConcreteHandler1");
            return;
        }

        // 如果不是当前责任  则继续寻找其他责任
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
