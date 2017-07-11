package com.sm.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Gallrax on 2017/7/11.
 */
@Aspect//只是标识这是一个AOP类，仍需声明@Component放入容器
@Component
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    private Logger logger = Logger.getLogger(getClass());

    /*
        execution( * com.sm.controller.*.*(..)) 没有权限修饰符标识拦截所有权限修饰符
        execution(public * com.sm.controller.*.*(..)) 只拦截public修饰的方法
     */
    @Pointcut("execution( * com.sm.controller.*.*(..))")
    public void cut() {
        logger.info("cut");
    }

    /*
        每个都可以设置argNames细粒度化
        JoinPoint真实类型：MethodInvocationProceedingJoinPoint
        顺序：未发生异常情况下：Around前 -> Before -> Around后 -> After -> AfterReturning
             发生异常情况下：Around前 -> Before -> After -> AfterThrowing
     */

    @Before("cut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("URL : "+ request.getRequestURL());
        logger.info("HTTP_METHOD : "+ request.getMethod());
        logger.info("IP : "+ request.getRemoteAddr());
        logger.info("CLASS_METHOD : "+ joinPoint.getSignature());//获取全限定方法名加参数 例：String com.sm.controller.IndexController.login()
        logger.info("ARGS : "+ Arrays.toString(joinPoint.getArgs()));
        System.out.println("----- 获取方法名： -----"+ joinPoint.getSignature().getName());
        System.out.println("----- 获取全限定类名： -----"+ joinPoint.getSignature().getDeclaringTypeName());
    }

    @Around("cut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("----- 环绕 块前 -----");
        Object o = pjp.proceed();
        logger.info("----- 环绕 块后 -----");
        return o;
    }

    @After("cut()")
    public void after(JoinPoint joinPoint) {
        logger.info("after : "+ joinPoint.getSignature());
    }

    @AfterReturning(value = "cut()",returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result) {
        logger.info("doReturn : "+ joinPoint.getSignature());
        logger.info("result : "+ result);
    }

    @AfterThrowing(throwing = "throwable", pointcut = "cut()")//throwing定义一个形参，和方法中一直
    public void tryThrow(JoinPoint joinPoint, Throwable throwable) {
        logger.info(joinPoint.getSignature() +" 发生异常："+ throwable.getMessage());
    }

}
