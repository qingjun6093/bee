package com.bee.client.controller.basic;

import com.bee.common.BeeClientResp;
import com.bee.passport.api.constant.PassportApiUrl;
import com.bee.passport.api.resp.RegisterSmsResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jiangjunqing
 * @date 2019/7/11
 * @desc 门户controller
 */
@Controller
public class PortalController {

    @RequestMapping(value = PassportApiUrl.registerSms,method = RequestMethod.POST)
    public BeeClientResp<RegisterSmsResp> sendRegisterSms(){
        return null;
    }










}
