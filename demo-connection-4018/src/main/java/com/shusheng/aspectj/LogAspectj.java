package com.shusheng.aspectj;

import cn.hutool.json.JSONUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 操作日期切面
 * @author 刘闯
 * @date 2022/5/25
 */
@Aspect
@Component
public class LogAspectj {

    private static final Logger log = LoggerFactory.getLogger(LogAspectj.class);

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(com.shusheng.annotations.Log)", returning = "jsonResult")
//    @AfterReturning(pointcut = "execution(* com.shusheng.controller.*.*(..))\"", returning = "jsonResult")
//    @AfterReturning(pointcut = "execution(* com.shusheng.controller.*.*(..))", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        // 设置方法名称
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        String response = JSONUtil.toJsonStr(jsonResult);

        System.out.println(className + "=== "+ methodName+"=== "+ params+"=== "+ response);

//        System.out.println("controllerLog = " + controllerLog);
    }


    /**
     * 切点为controller包下的所有public方法
     */
    @Pointcut("execution(* com.shusheng.controller.*.*(..))")
    public void aopBeforePointcut(){

    }

    // 执行前
    @Before(value = "aopBeforePointcut()")
    public void doMethodBefore(JoinPoint joinPoint){

    }

    /**
     * ：匹配DemoConnController类对应对象的所有方法，并且只能是DemoConnController的对象，不能是它的子对象。
     */
    @Pointcut("within(com.shusheng.controller.DemoConnController)")
    public void aopBeforePointcut1(){

    }
    /**
     * ：匹配com.shusheng包及其子包下面的所有类的所有方法。
     */
    @Pointcut("within(com.shusheng..*)")
    public void aopBeforePointcut2(){

    }

//    // 执行前
//    @Before(value = "execution(* com.shusheng.controller.*.*(..))")
//    public void doMethodBefore1(JoinPoint joinPoint){
//
//    }

//    args:
//    args用来匹配方法参数
//
//    args() 匹配不带参数的方法
//    args(java.lang.String) 匹配方法参数是String类型的
//    args(…) 带任意参数的方法
//    args(java.lang.String,…) 匹配第一个参数是String类型的，其他参数任意。最后一个参数是String的同理。


//    @annotation:
//    带有相应注解的方法，比如对标有@Transactional注解的方法进行增强
//
//    @annotation(org.springframework.transaction.annotation.Transactional)
//
//    @within和@target针对类的注解
//
//    @annotation针对方法的注解




    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("aopBeforePointcut2()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("通知类中的aroundAdvice方法执行了。。前置");

            rtValue = pjp.proceed(args);//明确调用切入点方法（切入点方法）

            System.out.println("通知类中的aroundAdvice方法执行了。。返回");
            System.out.println("返回通知："+rtValue);

            return rtValue;
        } catch (Throwable e) {
            System.out.println("通知类中的aroundAdvice方法执行了。。异常");
            throw new RuntimeException(e);
        } finally {
            System.out.println("通知类中的aroundAdvice方法执行了。。后置");
        }
    }
}
