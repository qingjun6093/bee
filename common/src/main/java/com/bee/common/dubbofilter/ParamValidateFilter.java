package com.bee.common.dubbofilter;

import com.bee.common.BeeResp;
import com.bee.common.constant.BeeCode;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcResult;
import org.apache.dubbo.validation.filter.ValidationFilter;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author jiangjunqing
 * @date 2019/12/2
 * @desc dubbo-provider参数验证过滤器
 *要开始验证功能,有两个步骤:
 * 1.对入参使用javax.validation.constraints下的注解
 * 2.注解org.apache.dubbo.config.annotation.Service(validation = "true")指定validation="true"
 *
 * 参数验证需要两个包,validation-api和hibernate-validation,这两个包都集成在spring-boot-stater-web里面
 */
@Activate(group = Constants.PROVIDER)
public class ParamValidateFilter extends ValidationFilter {

    @SuppressWarnings("rawtypes")
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) {
        Result result = super.invoke(invoker, invocation);
        if (result.hasException()){
            Throwable exception = result.getException();
            if (exception instanceof ConstraintViolationException){
                Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) exception).getConstraintViolations();
                BeeResp<?> response = new BeeResp(BeeCode.PARAM_INVALID.getValue(), BeeCode.PARAM_INVALID.getDesc());
                for (ConstraintViolation<?> item : constraintViolations) {
                    response.setMsg(item.getMessage());
                    break;
                }
                return new RpcResult(response);
            }
        }
        return result;
    }
}
