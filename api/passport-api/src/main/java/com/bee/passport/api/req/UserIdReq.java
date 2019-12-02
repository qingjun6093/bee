package com.bee.passport.api.req;

import com.alibaba.fastjson.JSON;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author jiangjunqing
 * @date 2019/12/2
 * @desc
 */
public class UserIdReq implements Serializable {
    private static final long serialVersionUID = -205376985640744504L;

    @Min(value = 1,message = "id不能小于1")
    private Long userId;

    public UserIdReq(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
