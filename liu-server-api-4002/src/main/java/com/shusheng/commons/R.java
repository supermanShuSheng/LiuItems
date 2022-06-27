package com.shusheng.commons;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回类封装
 * @author 刘闯
 * @date 2021/3/19.
 */
@ApiModel(description = "返回对象")
public class R<T> {
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T rows;
    /**
     * 数据大小
     */
    @ApiModelProperty(value = "返回大小")
    private Integer total;
    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private Integer code;
    /**
     * 返回消息
     */
    @ApiModelProperty(value = "返回消息")
    private String msg;

    public R() {
    }

    public R(T rows, Integer total, Integer code, String msg) {
        this.rows = rows;
        this.total = total;
        this.code = code;
        this.msg = msg;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer codes) {
        this.code = codes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "R{" +
                "rows=" + rows +
                ", total=" + total +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
