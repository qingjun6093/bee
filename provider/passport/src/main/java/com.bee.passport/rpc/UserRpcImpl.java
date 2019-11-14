package com.bee.passport.rpc;

import com.bee.passport.api.entity.User;
import com.bee.passport.api.rpc.UserRpc;
import com.bee.passport.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jiangjunqing
 * @date 2019/11/14
 * @desc 用户rpc
 */

@Service
public class UserRpcImpl implements UserRpc {

    @Autowired
    private UserDao userDao;

    public User getById(Long userId) {
        User user = userDao.getById(userId);
        return user;
    }
}
