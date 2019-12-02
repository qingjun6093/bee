package com.bee.common.pojo;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/29
 * @desc 所有实体的基类
 */
public class BaseEntity {

    /**
     * id
     */
    @NotNull
    private Long id;

    /**
     * 0=软删除,1=正常
     */
    private Byte state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
