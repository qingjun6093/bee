package com.bee.passport.api.rpc;

import com.bee.passport.api.entity.User;

/**
 * @author jiangjunqing
 * @date 2019/11/14
 * @desc 用户相关rpc
 */
public interface UserRpc {

    User getById(Long userId);
}
