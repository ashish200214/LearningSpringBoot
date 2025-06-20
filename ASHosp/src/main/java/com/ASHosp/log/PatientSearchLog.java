package com.ASHosp.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PatientSearchLog {
    @Around("execution(*.com.ASHosp.controller.SearchController.goToSearchPage(..))")
    public Object goToSearchPageLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Search Button Clicked");
        Object result = joinPoint.proceed();
        System.out.println("After Method: "+joinPoint.getSignature().getName());
        return result;
    }

    @Around("execution(*.com.ASHosp.controller.SearchController.searchPatientById(..))")
    public Object searchSubmitttedLog(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("Search by Patient Submitted");
        Object result = joinPoint.proceed();
        System.out.println("After Method: "+joinPoint.getSignature().getName());
        return result;
    }
    
}
