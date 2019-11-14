package com.bee.common;

import com.alibaba.fastjson.JSON;
import com.bee.common.constant.BeeCode;

import java.io.Serializable;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/16
 * @desc 全局基础响应类
 */
public class BeeResp<T> implements Serializable{
    private static final long serialVersionUID = 2663449263928417461L;

    private Integer code;

    private String msg;

    private T data;


    public  BeeResp success(){
        return new BeeResp(BeeCode.SUCCESS.getValue(),BeeCode.SUCCESS.getDesc());
    }


    public  BeeResp success(T data){
        return new BeeResp(BeeCode.SUCCESS.getValue(),BeeCode.SUCCESS.getDesc(), data);
    }

    public  boolean isSuccess(){
        return BeeCode.SUCCESS.getValue()==this.code;
    }


    public BeeResp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BeeResp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BeeResp() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
