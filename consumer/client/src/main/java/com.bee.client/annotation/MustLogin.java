package com.bee.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jiangjunqing
 * @date 2019/11/12
 * @desc 强制用户必须登陆(使用controller在方法上)
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MustLogin {
}
