package com.bee.passport.api.exception;

import com.bee.common.exception.BeeException;

/**
 * @author jiangjunqing
 * @date 2019/11/12
 * @desc passport抛出的异常
 */
public class PassportException extends BeeException {

    private final static String SOURCE = "passport";

    public PassportException(String message) {
        super(message, SOURCE);
    }

    public PassportException(Integer code, String message) {
        super(message, code, SOURCE);
    }
}
