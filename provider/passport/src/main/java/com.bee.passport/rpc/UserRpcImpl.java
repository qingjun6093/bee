package com.bee.passport.rpc;

import com.bee.common.BeeResp;
import com.bee.passport.api.entity.User;
import com.bee.passport.api.rpc.UserRpc;
import com.bee.passport.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jiangjunqing
 * @date 2019/11/14
 * @desc 用户rpc
 * 有关rpc返回体,统一包一个BeeResp这样的好处:
 * 1.服务间异常信息可以在各个服务之间准确传递
 * 2.便于参数验证
 */

@Service(validation = "true")
public class UserRpcImpl implements UserRpc {

    @Autowired
    private UserDao userDao;

    public BeeResp<User> getById(long userId){
        User user = userDao.getById(userId);
        return new BeeResp<User>(user);
    }
}
