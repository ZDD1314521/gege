package edu.soft2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAop {
    @Around("execution(* edu.soft2.service.UserService.addUser(..))")
    public Object aroundAdd(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println(pjp.getSignature().getName()+"前置环绕增强");
        Object result=pjp.proceed();
        System.out.println(pjp.getSignature().getName()+"后置环绕增强");
        return result;

    }

    @Around("execution(* edu.soft2.service.UserService.delUser(..))")
    public Object arounddel(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println(pjp.getSignature().getName()+"前置环绕增强");
        Object result=pjp.proceed();
        System.out.println(pjp.getSignature().getName()+"后置环绕增强");
        return result;

    }

    @Around("execution(* edu.soft2.service.UserService.seeUser(..))")
    public Object aroundSee(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println(pjp.getSignature().getName()+"前置环绕增强");
        Object result=pjp.proceed();
        System.out.println(pjp.getSignature().getName()+"后置环绕增强");
        return result;

    }

    @Around("execution(* edu.soft2.service.UserService.updUser(..))")
    public Object aroundupd(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println(pjp.getSignature().getName()+"前置环绕增强");
        Object result=pjp.proceed();
        System.out.println(pjp.getSignature().getName()+"后置环绕增强");
        return result;

    }



  /*  //1.设置切（入）点
    @Pointcut("execution(* edu.soft2.ioc.service..*.*(..))")//设置切入点的拦截范围
    public void pointA(){}
    //2.设置前置增强
    @Before("pointA()")
    public void beforeA(){System.out.println("UserAop前置增强!!!");}
    //3.设置后置增强
    @After("pointA()")
    public void afterA(){System.out.println("UserAop后置增强!!!");}
    //4.环绕增强
    @Around("pointA()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object res=null;
        System.out.println("准备执行目标对象("+pjp.getTarget()+")的("+pjp.getSignature().getName()+"()方法)");//环绕增强的前环绕
         res=pjp.proceed();//执行方法
        System.out.println("也执行目标对象("+pjp.getTarget()+")的("+pjp.getSignature().getName()+"()方法)");//环绕增强的后环绕
    return res;
    }
    @AfterReturning(value = "pointA()",returning = "result")
    public void afterRe(JoinPoint jp,Object result){
        System.out.println("执行完毕("+jp.getTarget()+")的("+jp.getSignature().getName()+"()方法)，返回值为:"+result);
    }*/
}
