package com.ASHosp.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HomePageLogClass {
    @Around("execution(*.com.ASHosp.controller.homePageController.welcome(..))")
    public Object logAroundForWelcomePage(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("/ is called : "+joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("After method: "+joinPoint.getSignature().getName());
        return result;
    }

    @Around("execution(*.com.ASHosp.controller.homePageController.goToRegisterPage(..))")
    public Object logAroundGoToRegisterPage(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Register Button Clicked : "+joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("After method: "+joinPoint.getSignature().getName());

        return result;
    }

    @Around("execution(*.com.ASHosp.controller.homePageController.goToDisplayPage(..))")
    public Object logAroundGoToDisplayPage(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Display Button Clicked : "+joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("After method: "+joinPoint.getSignature().getName());
        return result;
    }    

    
    
}
