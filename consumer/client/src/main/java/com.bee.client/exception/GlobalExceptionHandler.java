package com.bee.client.exception;

import com.bee.common.BeeResp;
import com.bee.common.constant.BeeCode;
import com.bee.common.constant.Num;
import com.bee.common.exception.BeeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author jiangjunqing
 * @date 2019/11/14
 * @desc 全局异常处理器
 * 处理BeeException和其他异常:
 * 有code的BeeException返回给前端;没有code的BeeException和其他的异常统一返回500给前端
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BeeResp<?> handleGlobalException(Exception e){
        if (e instanceof BeeException){
            logger.error("BeeException:{}", e.getMessage());
            Integer code = ((BeeException) e).getCode();
            if (code == null || code < Num.NUM_1){
                return new BeeResp<>(BeeCode.BEE_SERVER_ERROR.getValue(), BeeCode.BEE_SERVER_ERROR.getDesc());
            }else {
                return new BeeResp<>(((BeeException) e).getCode(), e.getMessage());
            }
        }
        logger.error("Exception:{}",e);
        return new BeeResp<>(BeeCode.BEE_SERVER_ERROR.getValue(), BeeCode.BEE_SERVER_ERROR.getDesc());
    }
}
