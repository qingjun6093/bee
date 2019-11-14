package com.bee.client.aspect;

import com.bee.common.constant.Num;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Parameter;

/**
 * @author jiangjunqing
 * @date 2019/11/13
 * @desc 日志切面
 */
@Aspect
@Component
public class LogAspect {
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 定义一个切入点
     */
    @Pointcut("execution(* com.bee.client.controller..*.*(..)) && args(..)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("===========================start===========================");
        //获取方法全名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getMethod().getName();
        String methodFullName = className + "." + methodName;
        //打印请求日志
        printRequest(joinPoint, methodFullName);
        //答应响应日志
        Object proceed = joinPoint.proceed();
        logger.info("{}|response:\n{}", methodFullName, proceed);
        logger.info("============================end============================");
        return joinPoint.proceed();
    }


    /**
     * 打印target请求参数,只抓取带@RequestBody注解的
     * @param joinPoint
     * @return
     */
    private void printRequest(ProceedingJoinPoint joinPoint, String methodFullName){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Parameter[] parameters = signature.getMethod().getParameters();
        if (parameters.length == Num.NUM_0){
            logger.info("{}|request:{}",methodFullName);
            return;
        }
        Parameter parameter = null;
        for (Parameter param : parameters){
            RequestBody annotation = param.getAnnotation(RequestBody.class);
            if (annotation !=null){
                parameter = param;
                break;
            }
        }
        if (parameter == null){
            logger.info("{}|request:{}",methodFullName);
            return;
        }
        Class<?> type = parameter.getType();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg.getClass() == type){
                logger.info("{}|request:\n{}",methodFullName,arg);
                break;
            }
        }
    }
}
