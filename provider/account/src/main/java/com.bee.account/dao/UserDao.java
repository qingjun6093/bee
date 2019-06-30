package com.bee.account.dao;

import com.bee.account.api.entity.User;
import com.bee.common.constant.EntityState;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/30
 * @desc
 */
@Component
public class UserDao {

    public User newUser(
            String name,
            String mobile,
            String password,
            String accountId,
            Date openAccountTime,
            Boolean isNovice,
            Long refereeId,
            Byte lockStatus,
            Byte status,
            Byte role,
            Date lastLoginTime
    ){
        User user = new User();
        user.setName(name);
        user.setMobile(mobile);
        user.setPassword(password);
        user.setAccountId(accountId);
        user.setOpenAccountTime(openAccountTime);
        user.setNovice(isNovice);
        user.setRefereeId(refereeId);
        user.setLockStatus(lockStatus);
        user.setStatus(status);
        user.setRole(role);
        user.setLastLoginTime(lastLoginTime);
        user.setState(EntityState.NORMAL.getValue());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return user;
    }

    public int insert(User user){
        return 0;
    }
}
