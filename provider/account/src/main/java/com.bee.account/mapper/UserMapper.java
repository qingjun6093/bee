package com.bee.account.mapper;

import com.bee.account.api.entity.User;
import com.bee.account.api.model.param.UserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/30
 * @desc 用户表mapper
 */
@Mapper
public interface UserMapper {

    int insert(@Param("entity") User user);

    int insertList(@Param("entities") List<User> userList);

    int update(@Param("entity") User user);

    User queryOne(@Param("param") UserParam param);

    List<User> queryList(@Param("param") UserParam param);

    int count(@Param("param") UserParam param);




}
