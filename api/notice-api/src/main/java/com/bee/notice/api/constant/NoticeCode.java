package com.bee.notice.api.constant;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/8/26
 * @desc 20000--29999 notice服务响应码
 */
public enum  NoticeCode {

    /**********20000--22999 短语相关错误码***********/
    SEND_BEYOND_LIMIT(20001,"短信发送过于频繁"),





    ;
    private int value;
    private String desc;

    NoticeCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
