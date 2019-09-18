package com.bee.common.constant;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/16
 * @desc 返回码
 */
public enum   BeeCode {
    SUCCESS(200, "Success"),
    PARAM_INVALID(400, "Param invalid"),
    UNAUTHORIZED(401, "Unauthorized"),
    BEE_SERVER_ERROR(500, "Bee server error"),
    ;

    /*************** 0--9999 基础响应码 ***********************/

    /*************** 10000--19999 passport服务响应码 ***********************/

    /*************** 20000--29999 notice服务响应码 ***********************/

    /*************** 30000--39999 bank服务响应码 ***********************/

    /*************** 40000--49999 invest服务响应码 ***********************/

    /*************** 50000--59999 loan服务响应码 ***********************/

    /*************** 60000--69999 activity服务响应码 ***********************/


    private int value;
    private String desc;

    BeeCode(int value, String desc) {
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
