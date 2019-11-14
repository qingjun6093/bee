package com.bee.client.aspect;

import com.bee.client.annotation.MustLogin;
import com.bee.client.exception.ClientException;
import com.bee.common.BeeReq;
import com.bee.common.constant.BeeCode;
import com.bee.common.constant.Num;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author jiangjunqing
 * @date 2019/11/13
 * @desc 登陆的切面处理
 * 此切面的优先级最低,在日志等切面之后
 */

@Aspect
@Component
@Order(Num.NUM_0)
public class LoginAspect {
    private static Logger logger = LoggerFactory.getLogger(LoginAspect.class);


    /**
     * 定义一个切入点
     */
    @Pointcut("execution(* com.bee.client.controller..*.*(..)) && args(..)")
    public void pointcut() {
    }

    /**
     * 登陆拦截,只能使用@Around不能使用前置通知,前置通知不能接收joinPoint参数
     * 有@MustLogin注解,检查传入的session在redis中是否存在,存在则赋值BeeReq.userId,不存在抛出未登录异常
     * 没有@MustLogin注解,检查传入的session在redis中是否存在,存在则赋值BeeReq.userId,不存在复制BeeReq.userId为null
     * @param joinPoint
     * @return
     */
    @Around("pointcut()")
    public Object loginIntercept(ProceedingJoinPoint joinPoint) throws Throwable {
        String session = getSession();
        //获取方法上的@MustLogin注解
        MethodSignature ms = (MethodSignature)joinPoint.getSignature();
        MustLogin mustLogin = ms.getMethod().getAnnotation(MustLogin.class);
        if (mustLogin != null ){
            if (!StringUtils.hasText(session)){
                throw new ClientException(BeeCode.SESSION_NOT_EXIST.getValue(),BeeCode.SESSION_NOT_EXIST.getDesc());
            }
            Long userId = getUserIdBySession(session);
            if (userId == null || userId < Num.NUM_1){
                throw new ClientException(BeeCode.UNAUTHORIZED.getValue(),BeeCode.UNAUTHORIZED.getDesc());
            }
        }
        //赋值BeeReq.userId
        Long userId = getUserIdBySession(session);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BeeReq){
                ((BeeReq) arg).setUserId(userId);
                break;
            }
        }
        //执行target并返回
        return joinPoint.proceed();
    }

    /**
     * 获取session(支持从Header中,body参数中和cookie中获取)
     * @return
     */
    private String getSession(){
        return " ";
    }

    /**
     * 通过session从redis中获取userId
     * @return
     */
    private Long getUserIdBySession(String session){
        if (StringUtils.hasText(session)){
            return 1L;
        }
        return  null;
    }

}
