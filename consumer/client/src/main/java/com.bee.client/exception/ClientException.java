package com.bee.client.exception;

import com.bee.common.exception.BeeException;

/**
 * @author jiangjunqing
 * @date 2019/11/12
 * @desc client抛出的异常
 */
public class ClientException extends BeeException {

    private final static String SOURCE = "client";

    public ClientException(String message) {
        super(message, SOURCE);
    }

    public ClientException(Integer code, String message) {
        super(message, code, SOURCE);
    }
}
