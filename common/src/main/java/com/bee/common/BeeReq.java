package com.bee.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author jiangjunqing
 * @date 2019/7/11
 * @desc client-客户端基础请求体
 */
public class BeeReq implements Serializable{

    private String platform = Platform.PC.desc;

    private String channel;

    private String isInvestor;

    private String ip;

    private String mid;

    private String appVersion;

    private Long userId;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public enum Channel {
        BEE("BEE","小蜜蜂端"),
        HORNET("HORNET","大黄蜂端")
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

    public enum Platform {
        PC("PC","web网页端"),
        IOS("IOS","ios"),
        ANDROID("ANDROID","android"),
        UNKNOWN("UNKNOWN","未知"),
        ;
        private String value;
        private String desc;

        Platform(String value, String desc) {
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
