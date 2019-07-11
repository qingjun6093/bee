package com.bee.common;

import com.alibaba.fastjson.JSON;
import com.bee.common.constant.BeeCode;
import com.bee.common.constant.BeeMsg;

import java.io.Serializable;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/16
 * @desc client全局基础响应类
 */
public class BeeClientResp<T> implements Serializable{
    private static final long serialVersionUID = 2663449263928417461L;

    private Integer code;

    private String msg;

    private T data;

    public  BeeClientResp success(){
        return new BeeClientResp(BeeCode.SUCCESS, BeeMsg.SUCCESS);
    }


    public  BeeClientResp success(T data){
        return new BeeClientResp(BeeCode.SUCCESS, BeeMsg.SUCCESS, data);
    }


    public BeeClientResp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BeeClientResp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
