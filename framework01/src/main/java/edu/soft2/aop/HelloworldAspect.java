package edu.soft2.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//public class HelloworldAspect implements IHelloworldService {
//    @Override
//    public void sayHello() {
//        System.out.println("你好，hello");
//    }
//}
//@Component//
//@Aspect
public class HelloworldAspect {
    //设置切点
    //@Pointcut(excution(public*edu.soft2.service.impl.HelloworldService.*.*(..)))
@Pointcut("execution(* edu.soft2.ioc.service..*.*(..))")
    public void myPointcut(){}
    /**
     * 前置增强
     */
    @Before("myPointcut()")
    public void beforeAdvice() {
        System.out.println("----前置通知(先执行到这里)------");
    }
        /**
         * 后置增强
         */
        @After("myPointcut()")
                public void afterAdvice() {
            System.out.println("---后置通知(后执行到这里)----");

        }

}