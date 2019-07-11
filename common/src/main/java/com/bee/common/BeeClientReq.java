package com.bee.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author jiangjunqing
 * @date 2019/7/11
 * @desc client-客户端基础请求体
 */
public class BeeClientReq implements Serializable{
    private static final long serialVersionUID = 2525986391450781138L;

    private String origin;

    private String channel;

    private String isInvestor;

    private String mid;

    private String ip;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getIsInvestor() {
        return isInvestor;
    }

    public void setIsInvestor(String isInvestor) {
        this.isInvestor = isInvestor;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public enum Channel {
        BEE("bee","小蜜蜂端"),
        HORNET("hornet","大黄蜂端")
        ;
        private String value;
        private String desc;

        Channel(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum Origin {
        PC("pc","web网页端"),
        IOS("ios","ios"),
        ANDROID("android","android"),
        UNKNOWN("unknown","未知"),
        ;
        private String value;
        private String desc;

        Origin(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }
    }
}
