package com.bee.account.api.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bee.common.pojo.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/29
 * @desc 用户表
 */
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8498775655129267530L;

    /**
     * 名字
     */
    private String name;

    /**
     * 注册手机号
     */
    private String mobile;

    @JSONField(serialize = false)
    private String password;

    /**
     * 存管电子账户
     */
    private String accountId;

    /**
     * 开户成功时间
     */
    private Date openAccountTime;

    /**
     * 是否是新手
     */
    private Boolean isNovice;

    /**
     * 推荐人id
     */
    private Long refereeId;

    /**
     * 锁定状态
     */
    private Byte lockStatus;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 角色
     */
    private Byte role;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public Boolean getNovice() {
        return isNovice;
    }

    public void setNovice(Boolean novice) {
        isNovice = novice;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    public Byte getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Byte lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public enum Role{
        DEFAULT((byte)0,"默认"),
        INVESTOR((byte)1,"投资人"),
        LOANER((byte)2,"借款人"),
        ;
        private Byte value;
        private String desc;

        Role(Byte value, String desc) {
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

    public enum Status{
        INIT((byte)0,"未注册成功"),
        REGISTER((byte)1,"注册成功"),
        OPEN_ACCOUNTING((byte)2,"开户中"),
        OPEN_ACCOUNT_SUCCESS((byte)3,"已开户"),
        OPEN_ACCOUNT_FAIL((byte)4,"开户失败"),
        ;
        private Byte value;
        private String desc;

        Status(Byte value, String desc) {
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

    public enum LockStatus{
        NORMAL((byte)0,"正常"),
        //如进入黑名单
        LOGIN_BAN((byte)1,"禁止登陆"),
        ;
        private Byte value;
        private String desc;

        LockStatus(Byte value, String desc) {
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

    @Override
    public String toString() {
      return JSON.toJSONString(this);
    }
}
