package com.bee.client.controller.passport;

import com.bee.common.BeeResp;
import com.bee.common.constant.BeeCode;
import com.bee.passport.api.constant.PassportApiUrl;
import com.bee.passport.api.entity.User;
import com.bee.passport.api.req.RegisterSmsReq;
import com.bee.passport.api.req.UserIdReq;
import com.bee.passport.api.resp.RegisterSmsResp;
import com.bee.passport.api.rpc.UserRpc;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiangjunqing
 * @date 2019/7/11
 * @desc 门户controller
 */
@Controller
public class PortalController {

    @Reference
    private UserRpc userRpc;

    @RequestMapping(value = PassportApiUrl.registerSms,method = RequestMethod.POST)
    @ResponseBody
    public BeeResp<User> sendRegisterSms(@RequestBody RegisterSmsReq req){
        BeeResp<User> resp = userRpc.getById(-1L);
        return resp;
    }











}
