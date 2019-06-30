package com.bee.common.constant;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/30
 * @desc 实体类的state枚举
 */
public enum EntityState {

    NORMAL((byte)1,"正常"),
    DELETED((byte)0,"软删除"),
    ;
    private Byte value;

    private String desc;

    EntityState(Byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Byte getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
