package com.bee.passport.rpc;

import com.bee.common.BeeResp;
import com.bee.passport.BeePassportApplicationTest;
import com.bee.passport.api.entity.User;
import com.bee.passport.api.req.UserIdReq;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jiangjunqing
 * @date 2019/12/2
 * @desc
 */

public class UserRpcTest extends BeePassportApplicationTest{
    private static Logger logger = LoggerFactory.getLogger(UserRpcTest.class);

    @Autowired
    private UserRpcImpl userRpc;

    @Test
    public void getById(){


    }
}
