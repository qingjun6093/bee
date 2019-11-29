package com.bee.passport.api.rpc;

import com.bee.common.BeeResp;
import com.bee.common.exception.BeeException;
import com.bee.passport.api.entity.User;

/**
 * @author jiangjunqing
 * @date 2019/11/14
 * @desc 用户相关rpc
 */
public interface UserRpc {

    /**
     * 根据id获取用户
     * @param userId
     * @return
     * @throws BeeException
     */
    BeeResp<User> getById(Long userId);
}
