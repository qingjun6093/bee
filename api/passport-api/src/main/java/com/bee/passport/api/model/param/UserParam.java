package com.bee.passport.api.model.param;

import com.alibaba.fastjson.JSON;
import com.bee.common.pojo.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/30
 * @desc 用户表查询参数
 */
public class UserParam extends BaseParam implements Serializable{

    private static final long serialVersionUID = 5954060939306668286L;

    /**
     * 名字
     */
    private String name;

    /**
     * 注册手机号
     */
    private String mobile;

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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
