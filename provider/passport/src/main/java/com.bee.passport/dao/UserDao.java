package com.bee.passport.dao;

import com.bee.common.constant.Num;
import com.bee.passport.api.entity.User;
import com.bee.common.constant.EntityState;
import com.bee.passport.api.model.param.UserParam;
import com.bee.passport.mapper.UserMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/30
 * @desc
 */
@Component
public class UserDao {

    @Resource
    private UserMapper userMapper;

    /**
     * 入库初始化User实体
     * @return
     */
    public User initDbUser(
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
        if (user == null){
            return 0;
        }
        return userMapper.insert(user);
    }

    public int insertList(List<User> userList){
        if (CollectionUtils.isEmpty(userList)){
            return 0;
        }
        return userMapper.insertList(userList);
    }

    public int update(User user){
        if (user == null || user.getId() == null || user.getId() < Num.NUM_0){
            return 0;
        }
        return userMapper.update(user);
    }

    public User queryOne(UserParam param){
        if (param == null){
            return null;
        }
        return userMapper.queryOne(param);
    }

    public User getById(Long userId){
        UserParam userParam = new UserParam();
        userParam.setId(userId);
        return userMapper.queryOne(userParam);
    }

    public List<User> queryList(UserParam param){
        if (param == null){
            return Collections.emptyList();
        }
        return userMapper.queryList(param);
    }

}
