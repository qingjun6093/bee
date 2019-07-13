package com.bee.passport.api.constant;

import com.bee.common.constant.ApiUrl;

/**
 * @author jiangjunqing
 * @date 2019/7/11
 * @desc
 */
public interface PassportApiUrl {

    String passport = ApiUrl.CLIENT + ApiUrl.PASSPORT;
    /**发送注册短信**/
    String registerSms = passport + "/sendRegisterSms";

}
